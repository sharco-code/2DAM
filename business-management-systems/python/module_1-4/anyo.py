
def isBisiesto(year):
    if(year > 1582):
        if(year % 4 != 0):
            return False
        elif(year % 100 != 0):
            return True
        elif(year % 400 != 0):
            return False
        else:
            return True

isBisiesto(int(input("Enter a year: ")))