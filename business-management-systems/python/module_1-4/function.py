INT = 0
STRING = 1

def fun(message, type):
    print(message ,end="")
    if(type == INT):
        return int(input())
    elif(type == STRING):
        return str(input())

x = fun("Enter a value:", INT)

print(x)