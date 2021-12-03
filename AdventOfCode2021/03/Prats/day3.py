import os
import math

cwd = os.path.dirname( __file__ )

inputName = "/input.txt"

data = []

with open(cwd + inputName) as file:
    lines = file.readlines()
    for line in lines:
        data.append(line.strip('\n'))
    file.close()

def binario_a_decimal(binario):
    posicion = 0
    decimal = 0
    binario = binario[::-1]
    for digito in binario:
        multiplicador = 2**posicion
        decimal += int(digito) * multiplicador
        posicion += 1
    return decimal

def onesWins(numList, digitCount):
    countOne = 0
    countZero = 0
    for number in numList:
        digits = [int(digit) for digit in str(number)]
        if digits[digitCount] == 1:
            countOne += 1
        else:
            countZero += 1
    return countOne >= countZero

def zerosWins(numList, digitCount):
    countOne = 0
    countZero = 0
    for number in numList:
        digits = [int(digit) for digit in str(number)]
        if digits[digitCount] == 1:
            countOne += 1
        else:
            countZero += 1
    return countOne < countZero

def recursiveOxygen(numList, digitCount):
    if (len(numList) < 2):
        return numList
    newNumListOnes = []
    newNumListZeros = []
    for number in numList:
        firstDigit = int(number[digitCount])
        if firstDigit == 1:
            newNumListOnes.append(number)
        else:
            newNumListZeros.append(number)
    if onesWins(numList, digitCount):
        digitCount += 1
        return recursiveOxygen(newNumListOnes, digitCount)
    elif zerosWins(numList, digitCount):
        digitCount += 1
        return recursiveOxygen(newNumListZeros, digitCount)

def recursiveCO2(numList, digitCount):
    if (len(numList) < 2):
        return numList
    newNumListOnes = []
    newNumListZeros = []
    for number in numList:
        firstDigit = int(number[digitCount])
        if firstDigit == 1:
            newNumListOnes.append(number)
        else:
            newNumListZeros.append(number)
    if onesWins(numList, digitCount):
        digitCount += 1
        return recursiveCO2(newNumListZeros, digitCount)
    elif zerosWins(numList, digitCount):
        digitCount += 1
        return recursiveCO2(newNumListOnes, digitCount)

def task1(data):
    numLenght = len([int(digit) for digit in str(data[0])])
    binGamma = [0]*numLenght
    binEpsilon = [0]*numLenght
    countListOne = [0]*numLenght
    countListZero = [0]*numLenght 
    for number in data:
        numList = [int(digit) for digit in str(number)]
        i = 0
        for digit in numList:
            if digit == 1:
                countListOne[i] += 1
            else:
                countListZero[i] += 1
            i += 1
    i = 0
    while i < numLenght:
        if countListOne[i] > countListZero[i]:
            binGamma[i] = 1
        else:
            binEpsilon[i] = 1
        i += 1
    return binario_a_decimal(binGamma) * binario_a_decimal(binEpsilon)

sol1 = task1(data)
    
print(sol1)

def task2(data):
    CO2Number = recursiveCO2(data, 0)
    oxygenNumber = recursiveOxygen(data, 0)
    return binario_a_decimal(CO2Number[0]) * binario_a_decimal(oxygenNumber[0])


sol2 = task2(data)

print(sol2)