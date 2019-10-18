def isYearLeap(year):
    if(year > 1582):
        if(year % 4 != 0):
            return False
        elif(year % 100 != 0):
            return True
        elif(year % 400 != 0):
            return False
        else:
            return True

def daysInMonth(year, month):
    if(month == 2):
        if(isYearLeap(year)):
            return 29
        else:
            return 28
    elif(month <= 7):
        if(month%2 == 0):
            return 30
    elif(month > 7):
        if(month%2 != 0):
            return 30
    return 31

def dayOfYear(year, month, day):
    x = 0
    for i in range(12):
        if(month-1 != i):
            x += daysInMonth(year, i+1)
        else:
            x += day
            return x

print(dayOfYear(1999, 12, 31))