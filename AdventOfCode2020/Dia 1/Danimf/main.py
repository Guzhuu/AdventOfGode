
def puzzle1(numbers):
    i = 0
    j = len(numbers) - 1
    finish = 0
    numbers.sort()

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
    return numbers[i], numbers[j]

def puzzle2(numbers):
    for i in range(0,len(numbers)):
        for j in range (i + 1, len(numbers)):
            for k in range (j + 1, len(numbers)):
                if numbers[i] + numbers[j] + numbers[k] == 2020:
                    return numbers[i], numbers[j], numbers[k]
    return 0
                    
numbers = []

with open("input.txt", "r") as file:
    lines = file.readlines()

    for line in lines:
        numbers.append(int(line))
    file.close()

number1, number2 = puzzle1(numbers)
print(f"Parte1:\nNumero 1: {number1} Numero 2: {number2}")
print(f"Multiplicacion = {number1*number2}")

num1, num2, num3 = puzzle2(numbers)
print(f"Parte2:\nNumero 1: {num1} Numero 2: {num2} Numero 3: {num3}")
print(f"Multiplicacion = {num1*num2*num3}")