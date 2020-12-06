with open("input.txt", "r") as archivo:
    data = archivo.read()
    archivo.close()

grupos = data.split("\n\n")

suma = 0
for grupo in grupos:
    personas = grupo.split("\n")
    respondidas = []
    for persona in personas:
        for pregunta in persona:
            if pregunta not in respondidas:
                respondidas.append(pregunta)
                suma += 1
print(suma)