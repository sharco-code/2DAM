# -*- coding: utf-8 -*-

from odoo import models, fields, api
import datetime
import secrets
import string

class facturas_model(models.Model):
    _name = 'facturacion.facturas_model'
    _order='ref'
    _sql_constraints = [("ref_repetida", "UNIQUE (ref)", "La referencia ya existe")]

    ref = fields.Char('Referencia', required=True)
    date = fields.Date('Fecha',required=True,default=datetime.datetime.strftime(datetime.datetime.today(), "%Y-%m-%d"))
    
    cliente_id = fields.Many2one('facturacion.clientes_model')

    #producto_id = fields.Many2many('facturacion.productos_model')

    cantidad_id = fields.One2many('facturacion.cantidad_model', 'factura_id')


    #base
    #total

    iva = fields.Selection([('21', '21%'), ('15', '15%'), ('7', '7%'),('0', '0%')],string="IVA", default='21', required=True)

    base = fields.Float('Base', compute='_base')

    total = fields.Float('Total', compute='_total', store = True)

    @api.multi 
    @api.depends("cantidad_id","base")
    def _base(self):
        self.base = 0
        for i in self.cantidad_id:
            self.base += float(i.cantidad) * i.producto_id.pvp
        return True

    @api.one 
    @api.depends("iva","base","total")
    def _total(self):
        if(self.iva=='21'):
            self.total = self.base + (self.base * 0.21)
        elif(self.iva=='15'):
            self.total = self.base + (self.base * 0.15)
        elif(self.iva=='7'):
            self.total = self.base + (self.base * 0.7)
        else:
            self.total = self.base
        return True
