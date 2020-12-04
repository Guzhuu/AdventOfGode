import re

color_ojo = ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"]
def resolver(pasaportes):

    validos = 0
    for pasaporte in pasaportes:
        count = 0
        for campo in pasaporte:
            valores = campo.split(":")
            nombre = valores[0]
            valor = valores[1]
            if nombre == "byr":
                valor = int(valor)
                if valor >= 1920 and valor <= 2002:
                    count += 1 
            elif nombre == "iyr":
                valor = int(valor)
                if valor >= 2010 and valor <= 2020:
                    count += 1 
            elif nombre == "eyr":
                valor = int(valor)
                if valor >= 2020 and valor <= 2030:
                    count += 1 
            elif nombre == "hgt":
                if (match := re.search(r"^([0-9]{3})(cm)$", valor)) or (match := re.search(r"^([0-9]{2})(in)$", valor)):
                    altura = int(match.group(1))
                    if match.group(2) == "cm":
                        if altura >= 150 and altura <= 193:
                            count += 1
                    elif match.group(2) == "in" :
                        if altura >= 59 and altura <= 76:
                            count += 1
            elif nombre == "hcl":
                if re.match(r"^#[0-9a-f]{6}$",valor):
                    count += 1
            elif nombre == "ecl":
                if valor in color_ojo:
                    count += 1
            elif nombre == "pid":
                if re.match(r"^[0-9]{9}$", valor):
                    count += 1
        if count == 7:
            validos += 1
    return validos

with open("input.txt", "r") as file:
    pasaportes = file.read().split("\n\n")
    file.close()

pasaportes = [line.split() for line in pasaportes]
print(resolver(pasaportes))