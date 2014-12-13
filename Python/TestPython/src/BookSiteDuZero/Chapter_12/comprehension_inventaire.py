#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''
def ordonner_inventaire(inventaire):
    inv_inventaire = [(nb,fruit) for(fruit,nb) in inventaire]
    return [(fruit, nb) for (nb,fruit) in sorted(inv_inventaire, reverse=True)]


if __name__ == '__main__':
    inventaire = [("pommes", 22),
                  ("melons",4),
                  ("poires",18),
                  ("fraises",76),
                  ("prunes",51)]
    inventaire_ordonne = ordonner_inventaire(inventaire)
    print(inventaire_ordonne)
    