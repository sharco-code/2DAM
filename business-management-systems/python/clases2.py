
class Clase:
    variable = 1
    def __init__(self):
        pass


claseEjemplo = Clase()

print("La clase tiene variable llamada 'variable':'", hasattr(claseEjemplo,'variable'))

print("Propiedades:",claseEjemplo.__dict__)
print("Variables estaticas:",Clase.__dict__)