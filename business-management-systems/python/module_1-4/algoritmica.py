
import re

while(True):
    x = re.findall(r'[\d.]+', input())
    d = int(x[0])
    n = int(x[1])
    a = -1
    s = 0
    b = True

    h = re.findall(r'[\d.]+', input())

    for i in range(int(n)):
        c = int(h[i])
        if a == -1:
            a = c
        else:
            if(c-a) > 0:
                s += (c-a)
                if s > d:
                    b = False
                else:
                    s = 0
                a = c
    if b:
        print("APTA")
    else:
        print("NO APTA")