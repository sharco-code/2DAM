year = int(input("Enter a year: "))

if(year < 1582):
    print("Año no valido")
else:
    if(year % 4 != 0):
        print("Año no valido")
    elif(year % 100 != 0):
        print("Año bisiesto")
    elif(year % 400 != 0):
        print("Año no bisiesto")
    else:
        print("Año bisiesto")