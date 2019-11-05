def mysplit(arg):
    lst = []
    s = ""
    for c in arg:
        if(c.isspace()):
            lst.append(s)
            s = ""
        else:
            s+=c
    if(s != ""):
        lst.append(s)
        
    return lst

print(mysplit("hola que tal"))