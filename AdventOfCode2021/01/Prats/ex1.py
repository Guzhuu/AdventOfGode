import os

cwd = os.path.dirname( __file__ )

numbers = []

with open(cwd + "/input.txt") as file:
    lines = file.readlines()
    for line in lines:
        numbers.append(int(line))
    file.close()

def task1(numbers):
    increasedCount = 0
    i = 0
    j = len(numbers) - 1
    finish = 0
    while i < j:
        if (numbers[i + 1] - numbers[i]) > 0:
            increasedCount += 1
        i += 1
    return increasedCount

def task2(numbers):
    increasedCount = 0
    i = 3
    j = len(numbers) - 1
    num1 = numbers[0] + numbers[1] + numbers[2]
    num2 = 0
    while i <= j:
        num2 = num1 - numbers[i - 3] + numbers[i]
        if (num2 - num1) > 0:
            increasedCount += 1
        num1 = num2
        i += 1
    return increasedCount

increasedCountex1 = task1(numbers)

increasedCountex2 = task2(numbers)

print(increasedCountex1)

print(increasedCountex2)