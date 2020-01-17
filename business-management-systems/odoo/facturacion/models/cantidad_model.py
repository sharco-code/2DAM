# -*- coding: utf-8 -*-

from odoo import models, fields, api
import datetime
import secrets
import string

class cantidad_model(models.Model):
    _name = 'facturacion.cantidad_model'

    producto_id = fields.Many2one('facturacion.productos_model', requiered = True)
    factura_id = fields.Many2one('facturacion.facturas_model')
    cantidad = fields.Integer('Cantidad', required  = True)