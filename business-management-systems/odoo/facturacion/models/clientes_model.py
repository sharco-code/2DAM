# -*- coding: utf-8 -*-

from odoo import models, fields, api
from odoo.exceptions import ValidationError
import datetime
import secrets
import string
import re

class clientes_model(models.Model):
    _name = 'facturacion.clientes_model'
    _sql_constraints = [("dni_repetido", "UNIQUE (dni)", "El dni ya existe")]
    _order='name'

    dni = fields.Char('DNI', required=True)
    image = fields.Binary("Foto")
    name = fields.Char('Nombre', required = True)
    surnames = fields.Char('Apellidos')
    telephone = fields.Char('Teléfono')
    email = fields.Char("Email")
    
    facturas = fields.One2many('facturacion.facturas_model', 'cliente_id')

    @api.one
    @api.constrains('dni')
    def checkDNI(self):
        x = ['T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E']
        try:
            if(x[int(self.dni[:-1])%23] == self.dni[-1:]):
                return True
            else:
                raise ValidationError('El dni esta mal introducido')
        except:
            raise ValidationError('El dni esta mal introducido')


    @api.one
    @api.constrains('email')
    def validate_mail(self):
       if self.email:
        match = re.match('^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$', self.email)
        if match == None:
            raise ValidationError('El email está mal introducido')

    @api.one
    @api.constrains('telephone')
    def _checkTelephone(self):

        try:
            if(len(self.telephone) != 9):
                raise ValidationError('El telefono tiene que ser de 9 digitos')
            else:
                return True
        except:
            raise ValidationError('El telefono esta mal introducido')

    