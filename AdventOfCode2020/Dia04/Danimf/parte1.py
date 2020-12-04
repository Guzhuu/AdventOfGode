
def resolver(pasaportes):
    validos = 0
    for pasaporte in pasaportes:
        campos_pasaporte = pasaporte.split(" ")

        if len(campos_pasaporte) == 8:
            validos += 1
        elif len(campos_pasaporte) == 7:
            validos += 1
            for campo in campos_pasaporte:
                if campo.split(":")[0] == "cid":
                    validos -= 1
                    break
    return validos

with open("input.txt", "r") as file:
    pasaportes = file.read()
    file.close()

pasaportes = pasaportes.split("\n\n")
pasaportes = [line.replace("\n", " ") for line in pasaportes]
print(resolver(pasaportes))