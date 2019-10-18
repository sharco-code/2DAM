import random

matriz = [["1","2","3"],["4","5","6"],["7","8","9"]]

_1 = matriz[0][0]
_2 = matriz[0][1]
_3 = matriz[0][2]

_4 = matriz[1][0]
_5 = matriz[1][1]
_6 = matriz[1][2]

_7 = matriz[2][0]
_8 = matriz[2][1]
_9 = matriz[2][2]

def show():
    print()
    for i in range(3):
        for j in range(3):
            print(matriz[i][j],"   ", end="")
        print(end="\n\n")

def win(arg):
    if(_1 == arg and _2 == arg and _3 == arg):
        return True
    if(_4 == arg and _5 == arg and _6 == arg):
        return True
    if(_7 == arg and _8 == arg and _9 == arg):
        return True

    if(_1 == arg and _4 == arg and _7 == arg):
        return True
    if(_2 == arg and _5 == arg and _8 == arg):
        return True
    if(_3 == arg and _6 == arg and _9 == arg):
        return True

    if(_1 == arg and _5 == arg and _9 == arg):
        return True
    if(_7 == arg and _5 == arg and _3 == arg):
        return True
    return False

iac = 0
def ia(argc):
    if(argc == 0):
        matriz[1][1] = "O"
    while True:
        posicion = random.randint(0,9)
        if(posicion%3 == 0):
            fila = int(posicion/3) - 1
            columna = 2
        else:
            fila = int(posicion / 3)
            columna = int(posicion % 3) -1
        if(matriz[fila][columna]!= "X" and matriz[fila][columna]!= "O"):
            matriz[fila][columna] = "O"
            break
    argc += 1
        

    
def player(argc):
    if(argc == 1):
        matriz[0][0] = "X"
    if(argc == 2):
        matriz[0][1] = "X"
    if(argc == 3):
        matriz[0][2] = "X"
    if(argc == 4):
        matriz[1][0] = "X"
    if(argc == 5):
        matriz[1][1] = "X"
    if(argc == 6):
        matriz[1][2] = "X"
    if(argc == 7):
        matriz[2][0] = "X"
    if(argc == 8):
        matriz[2][1] = "X"
    if(argc == 9):
        matriz[2][2] = "X"


show()
print("'e' para empezar:", end="")
if(input()=="e"):
    ia(iac)
show()

for n in range(1000):
    print("Te toca:", end="")
    player(int(input()))
    show()

