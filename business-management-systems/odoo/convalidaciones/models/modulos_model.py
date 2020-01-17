# -*- coding: utf-8 -*-

from odoo import models, fields, api

class modulos_model(models.Model):
    _name = 'convalidaciones.modulos_model'

    name = fields.Char('Nombre', required = True)
    descripcion = fields.Text('Descripción')
    horas = fields.Integer('Horas')

    convalidaciones = fields.One2many('convalidaciones.convalidaciones_model', 'modulo_id')

    ciclo_id = fields.Many2many('convalidaciones.ciclos_model')