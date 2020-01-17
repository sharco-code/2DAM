# -*- coding: utf-8 -*-

from odoo import models, fields, api
from odoo.exceptions import ValidationError
import datetime
import secrets
import string

class history_model(models.Model):
    _name = 'gestion_pacientes.history_model'

    patient_id = fields.Many2one('gestion_pacientes.patient_model', required=True)
    date = fields.Date('Fecha',required=True,default=datetime.datetime.strftime(datetime.datetime.today(), "%Y-%m-%d"))
    detail = fields.Html('Detalle')
