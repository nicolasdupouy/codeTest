#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on 1 avr. 2013

@author: nicolasdupouy
'''


    
if __name__ == '__main__':
    
    # Formatage d'une adresse
    adresse = """{no_rue}, {nom_rue} {code_postal} {nom_ville} ({pays})""".format(no_rue=15, nom_rue="rue La Condamine", code_postal=75017, nom_ville="Paris", pays="France")
    
    print(adresse)