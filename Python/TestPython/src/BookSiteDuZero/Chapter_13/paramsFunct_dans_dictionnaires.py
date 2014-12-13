#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

def fonction_inconnue(*params_en_liste, **params_en_dictionnaire):
    if len(params_en_liste) != 0:
        print("J'ai reçu en paramètres nommés (liste): {}.".format(params_en_liste))
    if len(params_en_dictionnaire) != 0:
        print("J'ai reçu en paramètres nommés (dictionnaire): {}.".format(params_en_dictionnaire))

if __name__ == '__main__':
    fonction_inconnue()
    fonction_inconnue(p=4, j=8)
    fonction_inconnue(1, 2, "E", ["a", "b"], 56)