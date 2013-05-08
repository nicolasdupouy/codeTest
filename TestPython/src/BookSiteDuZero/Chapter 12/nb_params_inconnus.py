#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

def fonction_inconnue(*parameters):
    """Test d'une fonction pouvant être appelée avec un nombre
    variable de paramètres"""
    
    print("J'ai reçu: {}".format(parameters))


if __name__ == '__main__':
    fonction_inconnue("bla", 1, 2, (4, "test"))