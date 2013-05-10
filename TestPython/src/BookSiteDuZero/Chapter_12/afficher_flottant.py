#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

def afficher_flottant(flottant):
    if type(flottant) is not float:
        raise TypeError("Le paramètre attendu doit être flottant")
    flottant = str(flottant)
    if len(flottant)>5:
        partie_entiere, reste = flottant.split(".")
        reste = reste[0:3]
        flottant = ".".join((partie_entiere, reste))
    print(flottant)
    
if __name__ == '__main__':
    afficher_flottant(1.345)
    afficher_flottant(3.9999999999)
    afficher_flottant(1.5)