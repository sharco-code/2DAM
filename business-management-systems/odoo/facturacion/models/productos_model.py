# -*- coding: utf-8 -*-

from odoo import models, fields, api
import secrets
import string

class productos_model(models.Model):
    _name = 'facturacion.productos_model'
    _sql_constraints = [("ref_repetido", "UNIQUE (name)", "La referencia ya existe")]
    _order='name'

    name = fields.Char('Referencia', required=True)
    description = fields.Html('Descripcion')
    pvp = fields.Float('Precio')
    stock = fields.Integer('Stock', default=0)
    #factura_id = fields.Many2many('facturacion.facturas_model')

    cantidad_id = fields.One2many('facturacion.cantidad_model', 'producto_id')

    @api.multi 
    @api.depends("stock")
    def addStock(self):
        #deberia salir una ventana para añidir stock
        self.stock += 1
        return True