#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 8, 2013

@author: nicolas
'''

import pickle

if __name__ == '__main__':
    with open("donnees", "rb") as fichier:
        nom_depickler = pickle.Unpickler(fichier)
        score_recupere = nom_depickler.load()
        print(score_recupere)