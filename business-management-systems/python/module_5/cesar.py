def cifrar(str, n):
    s = ''
    for c in str:
        if(not c.isalnum() or c.isspace()):
             s += c
             continue
        if(ord(c)+n > 90 and ord(c) < 97):
            s+= chr((ord(c)-6)+n)
            continue
        if(ord(c)+n > 122):
            s+= chr((ord(c)-58)+n)  
            continue
        s += chr(ord(c)+n)
    return s

def descifrar(str, n):
    s = ''
    for c in str:
        if(not c.isalnum() or c.isspace()):
             s += c
             continue
        if(ord(c)+n > 90 and ord(c) < 97):
            s+= chr((ord(c)-6)+n)
            continue
        if(ord(c)+n > 122):
            s+= chr((ord(c)-58)+n)
            continue
        s += chr(ord(c)-n)
    return s

print(cifrar("aholaz",1))
print(descifrar(cifrar("aholaz",1),1))