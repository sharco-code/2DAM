# -*- coding: utf-8 -*-

from odoo import models, fields, api
import secrets
import string

class alumnos_model(models.Model):
    _name = 'convalidaciones.alumnos_model'

    name = fields.Char('Nombre', required = True)
    password = fields.Char('Contraseña', required = False)
    foto = fields.Binary("Foto")
    edad = fields.Integer("Edad")
    localidad = fields.Char("Localidad")
    provincia = fields.Char("Provincia")
    email = fields.Char("Email")

    convalidaciones = fields.One2many('convalidaciones.convalidaciones_model', 'alumno_id')

    ciclo_id = fields.Many2one('convalidaciones.ciclos_model')
    

    @api.one
    def generatePassword(self):
        alphabet = string.ascii_letters + string.digits
        password = ''.join(secrets.choice(alphabet) for i in range(8))

        self.password = password

        return True