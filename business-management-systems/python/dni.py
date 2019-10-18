
def calcDNI(dni):
    x = ['T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E']
    if(dni%23<0 | dni%23>23 | len(dni)>8 | len(dni)<0):
        return None
    return x[dni%23]

dni = int(input("DNI:"))

print(dni, calcDNI(dni), sep="")