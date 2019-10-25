s = str(input("string: "))
s = s.upper()
s2 = ""

def isVocal(char):
    if(char=='A'):
        return True
    if(char=='E'):
        return True
    if(char=='I'):
        return True
    if(char=='O'):
        return True
    if(char=='U'):
        return True
    else:
        return False

for i in s:
    if(isVocal(i)==False):
        print(i, end="")
    pass

#print(s2)