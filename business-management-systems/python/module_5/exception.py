'''
try:
    print(" - 1")
    print(0/0)
    print(" - 2")
except:
    print("no se puede dividir entre 0")
'''

def badfun(n):
    raise ZeroDivisionError

try:
    badfun(0)
except ArithmeticError:
    print("mal")

print("----------------------")

var = 0

try:
    var = 1
    print(0/0)
except:
    var = 0
    pass

print(var)