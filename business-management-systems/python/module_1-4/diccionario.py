def addStudent(dictionary, key, value):
    if key in dictionary.keys():
        dictionary[key].append(value)
    else:
        dictionary.update({key : [value]})

def getAverage(notes):
    total = 0
    noteCount = 0
    for i in notes:
        total += i
        noteCount += 1
    return total/noteCount

clase = {}
while True:
    key = input("Alumno: ")
    if(key == "-1"):
        break
    value = float(input("Nota: "))
    addStudent(clase,key,value)


for key,value in clase.items():
    print(key," media  - ", getAverage(value))
    print(key," minimo - ", max(value))
    print(key," maximo - ", min(value))