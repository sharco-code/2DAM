import string, operator

class Histograma:

    def __init__(self, fichero):
        self._fichero = fichero

    def histograma(self):
        dicc = {}

        try:
            s = open(self._fichero, "rt")
            print("Leyendo archivo:",self._fichero)
            ch = s.read(1)
            while ch != '':
                if(ch == '\n' or ch == ' '):
                    ch = s.read(1)
                    continue
                if ch in dicc:
                    dicc[ch] = dicc[ch] + 1
                else:
                    dicc[ch] = 1
                ch = s.read(1)
            s.close()
        except IOError as e:
            print("IOERROR: ",e)

        return dicc

programa = Histograma('documento.txt')
diccionario = programa.histograma()

for clave in sorted(diccionario.items(), key=operator.itemgetter(1), reverse=True):
    #print(clave)
    print("Numero de '",clave[0],"': ",clave[1], sep='')
