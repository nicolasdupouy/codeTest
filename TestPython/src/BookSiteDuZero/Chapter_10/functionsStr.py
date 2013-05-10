#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

if __name__ == '__main__':
    minuscules = "une chaine en minuscules"
    print(minuscules.upper())
    print(minuscules.capitalize())
    
    espaces = "    une chaine avec des espaces    "
    print(espaces.strip())
    
    titre = "introduction"
    print("#" + titre.upper().center(20) + "#")
    