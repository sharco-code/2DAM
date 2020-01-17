# -*- coding: utf-8 -*-

from odoo import models, fields, api

class ciclos_model(models.Model):
    _name = 'convalidaciones.ciclos_model'

    name = fields.Char('Nombre', required = True)
    descripcion = fields.Text('Descripción')

    # alumno_id = fields.Many2one('convalidaciones.alumnos_model')

    alumno_id = fields.One2many('convalidaciones.alumnos_model', 'ciclo_id')

    modulo_id = fields.Many2many('convalidaciones.modulos_model')