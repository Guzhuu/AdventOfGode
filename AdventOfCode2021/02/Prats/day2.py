import os

cwd = os.path.dirname( __file__ )

forward = "forward"
down = "down"
up = "up"

data = []

with open(cwd + "/input.txt") as file:
    lines = file.readlines()
    for line in lines:
        data.append(line.strip('\n'))
    file.close()

def task1(data):
    horizontal = 0
    vertical = 0
    for action in data:
        direction = action.split()[0]
        unit = int(action.split()[1])
        if direction == forward:
            horizontal += unit
        elif direction == down:
            vertical += unit
        else:
            vertical -= unit
    return horizontal * vertical
    

def task2(data):
    aim = 0
    horizontal = 0
    vertical = 0
    for action in data:
        direction = action.split()[0]
        unit = int(action.split()[1])
        if direction == forward:
            horizontal += unit
            vertical += (unit * aim)
        elif direction == down:
            aim += unit
        else:
            aim -= unit
    return horizontal * vertical

sol1 = task1(data)

sol2 = task2(data)

print(sol1)

print(sol2)



