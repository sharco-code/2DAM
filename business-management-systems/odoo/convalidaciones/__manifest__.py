# -*- coding: utf-8 -*-
{
    'name': "Convalidaciones",

    'summary': "Módulo para la gestión de Alumnos, Módulos, Convalidaciones, y Ciclos de un IES",

    'description': """
        Permite gestionar Alumnos, Módulos, Convalidaciones, y Ciclos de un IES
    """,

    'author': "Jose Galán",
    'website': "http://www.jgalan.com",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/12.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        'security/ir.model.access.csv',
        'views/modulos_view.xml',
        'views/ciclos_view.xml',
        'views/convalidaciones_view.xml',
        'views/alumnos_view.xml',
        'views/menu_view.xml',
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],

    'application': True,
    'installable': True,
}