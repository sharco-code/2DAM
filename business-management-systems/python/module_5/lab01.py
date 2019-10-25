def readint(prompt, min, max):
    try:
        i = int(input(prompt))
        if(i>=min and i<max):
            return i
        else:
            print("tiene que ser entre",min,"y",max)
            readint(prompt, min, max)
    except:
        print("Tiene que ser un numero")
        readint(prompt, min, max)

def readfloat(prompt, min, max):
    try:
        i = float(input(prompt))
        if(i>=min and i<max):
            return i
        else:
            print("tiene que ser entre",min,"y",max)
            readint(prompt, min, max)
    except:
        print("Tiene que ser un numero")
        readint(prompt, min, max)

v = readint("(int) Enter a number from -10 to 10:",-10,10)

print("El numero es:",v)

v = readfloat("(float) Enter a number from -10 to 10:",-10,10)

print("El numero es:",v)