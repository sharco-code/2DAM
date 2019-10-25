matriz = [["1","2","3"],["4","5","6"],["7","8","9"]]
posicion = 8
if(posicion%3 == 0):
    fila = int(posicion/3) - 1
    columna = 2
else:
    fila = int(posicion / 3)
    columna = int(posicion % 3) -1

print(fila, columna)
print(8%3 == 0)
print(8%7)