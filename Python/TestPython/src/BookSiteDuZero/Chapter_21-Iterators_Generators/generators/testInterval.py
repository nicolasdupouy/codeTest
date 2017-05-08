#!/opt/bin/python3

from interval import *

generator = interval(1, 10)
for number in generator:
    if number == 5:
        generator.send(8)
    print(number)