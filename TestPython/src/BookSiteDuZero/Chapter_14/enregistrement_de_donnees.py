#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 8, 2013

@author: nicolas
'''

import pickle

if __name__ == '__main__':
    score = {
             "joueur 1":    5,
             "joueur 2":    35,
             "joueur 3":    20,
             "joueur 4":    4
             }
    
    with open('donnees', 'wb') as fichier:
        nom_pickler = pickle.Pickler(fichier)
        nom_pickler.dump(score)
    
    