diccionario = {}

recaudado = 0.

def addFactura(diccionario, numFactura, coste):
    diccionario.update({numFactura : float(coste)})

def pagoFactura(diccionario, numFactura):
    coste = diccionario.get(numFactura)
    del diccionario[numFactura]
    return coste

while True:
    pendienteDeCobro = 0.
    
    for i,j in diccionario.items():
        pendienteDeCobro += j


    print("Recaudado:", recaudado)
    print("Pendiente de cobro:", pendienteDeCobro)

    opcion = input("¿Quieres añadir una nueva factura (A), pagarla (P), o terminar (T)? ")
    if(opcion == 'A'):
        addFactura(diccionario, input("Introduce el número de la factura: "),input("Introduce el coste de la factura: "))
    elif(opcion == 'P'):
        recaudado += pagoFactura(diccionario, input("Introduce el numero de la factura a pagar: "))
    else:
        break

