# -*- coding: utf-8 -*-
{
    'name': "Facturacion",

    'summary': "Modulo para gestion de facturas (examen python)",

    'description': """
        Modulo para gestion de facturas (examen python) Jose Galan Simo
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
        'views/clientes_view.xml',
        'views/productos_view.xml',
        'views/facturas_view.xml',
        'views/cantidad_view.xml',
        'views/menu_view.xml',
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],

    'application': True,
    'installable': True,
}