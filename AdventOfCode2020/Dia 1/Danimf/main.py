numbers = []

with open("input.txt", "r") as file:
    lines = file.readlines()

    for line in lines:
        numbers.append(int(line))
    file.close()

numbers.sort()

i = 0
j = len(numbers) - 1
finish = 0


while not finish:
    add = numbers[i] + numbers[j]

    if add > 2020:
        j -= 1
    elif add < 2020:
        i += 1
    elif i == j:
        finish = 1
    else:
        finish = 1
    add = 0

print(f"Numero 1: {numbers[i]} Numero 2: {numbers[j]}")
print(f"Multiplicacion = {numbers[i]*numbers[j]}")