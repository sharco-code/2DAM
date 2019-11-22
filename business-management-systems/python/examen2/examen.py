x = 1
class Pib:
    def __init__(self, url):
        self._url = url

    def leer(self, pais):
        d = {}
        try:
            s = open(self._url, "rt")
            ch = s.readline()
            for i in range(21):
                ch = s.readline()
                _pais = ch.split(";")
                if(_pais[0] == pais):
                    year = 2000
                    for num in _pais:
                        if(num != _pais[0]):
                            d[year] = num
                            year+=1
                    return d
                
                    
        except IOError as e:
            print("No se encuentra el archivo: ", e.__str__)
        finally:
            s.close()

        return None


pib = Pib("pib.csv")

pais = input("Introduce Pais:")
while pais!="FIN":
    if(pib.leer(pais) != None):
        print("PIB del pais:",pais)
        d = pib.leer(pais)
        maxi = -1
        mini = 99999999
        for i in sorted(d):
            print("Año",i,":",d[i])
            
            if(mini > int(d[i])):
                mini = int(d[i])
            if(maxi < int(d[i])):
                maxi = int(d[i])
           
        
        print("Minimo:",mini)
        print("Maximo:",maxi)
    else:
        print("Pais sin PIB")
    pais = input("Introduce Pais:")


