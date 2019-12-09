# -*- coding: utf-8 -*-

from odoo import models, fields, api

class convalidaciones_model(models.Model):
    _name = 'convalidaciones.convalidaciones_model'

    name = fields.Char(default="Convalidacion")

    fecha = fields.Date('Fecha', required=True)

    modulo_id = fields.Many2one('convalidaciones.modulos_model')
    alumno_id = fields.Many2one('convalidaciones.alumnos_model')

    @api.one
    @api.constrains('fecha')
    def checkDate(self):
        selected_date = fields.Date.from_string(self.fecha).strftime('%Y%m%d')
        today = fields.Date.from_string(fields.Date.today()).strftime('%Y%m%d')
        if(int(today) - int(selected_date)) <= 0:
            raise Warning('La fecha tiene que ser anterior a hoy')
        return True