tablero = [1,2,3,4,5,6,7,8,9]

def show():
    print()
    for i in range(3):
        print(tablero[i],"   ", end="")
    print(end="\n\n")
    for i in range(3,6):
        print(tablero[i],"   ", end="")
    print(end="\n\n")
    for i in range(6,9):
        print(tablero[i],"   ", end="")
    print(end="\n\n")
   
def win(arg):
    for i in range(1,10):
        if(i == 1 or i == 4 or i == 7):
            if(tablero[i] == arg and tablero[i+1] == arg and tablero[i+2] == arg):
                return True
        if(i == 1 or i == 2 or i == 3):
            if(tablero[i] == arg and tablero[i+3] == arg and tablero[i+6] == arg):
                return True
        if(i == 1):
            if(tablero[i] == arg and tablero[i+4] == arg and tablero[i+8] == arg):
                return True
        if(i == 3):
            if(tablero[i] == arg and tablero[i+2] == arg and tablero[i+4] == arg):
                return True
        return False


show()
print("E para empezar:", end="")
if(input()=="e"):
    