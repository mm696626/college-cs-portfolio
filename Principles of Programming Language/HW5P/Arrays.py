import random
print("Welcome to the Arrays Program in Python")
print("Written by Matt McCullough")
print("With assistance from Andy Mac")
size = int(input("Enter a value: "))

randomlist = []
for i in range(0,size):
    n = random.randint(10,99)
    randomlist.append(n)
print(randomlist)