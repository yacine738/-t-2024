import random

random_number = random.randint(1, 10)

x = None

while x != random_number:
    x = int(input("Enter a number between 1 and 10: "))

if x == random_number:
    print("Congratulations, you guessed correctly!")