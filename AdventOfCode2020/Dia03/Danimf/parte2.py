def resolver(camino, movimientoX, movimientoY):
    actualX = 0
    actualY = 0
    arboles = 0

    while (actualY := actualY + movimientoY) <= len(camino):
        actualX = (actualX + movimientoX) % len(camino[actualY])

        if camino[actualY][actualX] == '#':
            arboles += 1
    return arboles

with open("input.txt", "r") as file:
    global lineas

    lineas = [linea.strip() for linea in file.readlines()]
    file.close()

arboles = resolver(lineas, 1, 1)
arboles *= resolver(lineas, 3, 1)
arboles *= resolver(lineas, 5, 1)
arboles *= resolver(lineas, 7, 1)
arboles *= resolver(lineas, 1, 2)
print(arboles)