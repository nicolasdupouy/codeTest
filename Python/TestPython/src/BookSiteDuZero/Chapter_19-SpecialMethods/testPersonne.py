#!/opt/bin/python3

from Personne import *

p = Personne("Nicolas", "Dupouy")
# => __str__
print(p)
# => __repr__
p
# => __str__
p2 = str(p)

