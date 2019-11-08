
class Stack:

    def __init__(self):
        self.__pila = []
        print("constructor")

    def push(self, arg):
        self.__pila.append(arg)
    
    def pop(self):
        if len(self.__pila) == 0:
            return None
        res = self.__pila[-1]
        del self.__pila[-1]
        return res

class PilaSuma(Stack):

    def __init__(self):
        Stack.__init__(self)
        self.__suma = 0

    def push(self, arg):
        Stack.push(self, arg)
        self.__suma += arg

pilaSuma = PilaSuma()
pilaSuma.push(6)
print(pilaSuma.pop())
print(PilaSuma.__dict__)