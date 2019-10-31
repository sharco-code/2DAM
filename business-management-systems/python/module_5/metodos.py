
print("aaAA".capitalize()) # primera letra mayuscula y las restantes en minuscula

print("aaAA".endswith("AA")) # Si acaba con 
print("omega".startswith("om")) # Si empieza con

print("aaAA".find("AA")) # Devuelve la posición de donde empieza la subcadena
print("Hola que tal que tal".find("que",6)) # 6* desde donde empieza a buscar

print("a ".isalnum()) # dígitos y o letras true, otros caracteres false

print("Moo".isalpha()) # True si solo contiene letras
print("Moo".isdigit()) # True si solo contiene dígitos

print("aaaa".islower())
print(" ".isspace())
print("AAA".isupper())

print("-".join(['hola', 'que', 'tal']))

print("      Hola".lstrip())  # left strip, si no se le pasa nada corta espacios en blanco
print("Hola      ".rstrip())  # right strip, si no se le pasa nada corta espacios en blanco
print("    Hola   ".strip())  # strip, si no se le pasa nada corta espacios en blanco

print("Tinti".replace('i','o'))

print("AAXAA".split("X"))

print("aaaAAAA".swapcase())

print("i know that i know nothing".title())
