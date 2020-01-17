# -*- coding: utf-8 -*-

from odoo import models, fields, api
from odoo.exceptions import ValidationError
from datetime import date
import secrets
import string

class patient_model(models.Model):
    _name = 'gestion_pacientes.patient_model'
    #_sql_constraints = [("dni_repetido", "UNIQUE (dni)", "El dni ya existe")]

    dni = fields.Char('DNI', required=True)
    name = fields.Char('Nombre', required = True)
    surnames = fields.Char('Apellidos')
    telephone = fields.Char('Teléfono')
    birth = fields.Date('Fecha de Nacimiento', required=True)
    email = fields.Char("Email")
    
    image = fields.Binary("Foto")

    visits = fields.One2many('gestion_pacientes.history_model', 'patient_id')
    visitsCount = fields.Integer('Visitas', compute='_visitsCount')

    @api.one 
    @api.depends("visits","visitsCount")
    def _visitsCount(self):

        if(self.visits is None):
            self.visitsCount = 0
        else:    
            self.visitsCount = len(self.visits)
        return True
"""
    @api.multi
    def _deleteHistory(self):
        
        pass

    @api.one
    @api.constrains('birth')
    def _checkBirth(self):
        born = date(fields.Date.from_string(self.birth).strftime('%y),
                fields.Date.from_string(self.birth).strftime('%m),
                fields.Date.from_string(self.birth).strftime('%d'))
                
        today = date.today()
        if((today.year - born.year - ((today.month, today.day) < (born.month, born.day)))>=18):
            return True
        else:
            raise ValidationError('Tiene que tener minimo 18 años')

    @api.one
    @api.constrains('dni')
    def _checkDNI(self):
        x = ['T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E']
        #    return x[dni%23]
        try:
            if(x[int(self.dni[:-1])%23] == self.dni[-1:]):
                return True
            else:
                raise ValidationError('El dni esta mal introducido')
            '''
            if(len(self.dni) != 9):
                raise ValidationError('El dni esta mal introducido')
            if(int(self.dni[:-1])%23<0 | int(self.dni[:-1])%23>23):
                raise ValidationError('El dni esta mal introducido')
            return True
            '''
        except
            raise ValidationError('El dni esta mal introducido')
        
        
   """     

    
