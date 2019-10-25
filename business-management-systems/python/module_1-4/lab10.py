blocks = int(input("Enter the number of blocks: "))

height = 0
x = 1
while x <= blocks:
    height += 1
    blocks -= x
    x += 1
    pass

print("The height of the pyramid:", height)