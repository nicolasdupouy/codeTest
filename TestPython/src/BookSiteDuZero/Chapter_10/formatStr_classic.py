#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on 20 mars 2013

@author: nicolasdupouy
'''

if __name__ == '__main__':
    prenom = "Nicolas"
    nom = "Dupouy"
    age = 33
    
    print("Je m'appelle {0} {1} et j'ai {2} ans.".format(prenom, nom, age))
    
    print("Je m'appelle {0} {1} ({3} {0}) et j'ai {2} ans.".format(prenom, nom, age, nom.upper()))
    
    
    date = "Lundi 01 Avril 2013"
    heure = "01:30"
    print("Cela s'est produit le {}, à {}.".format(date, heure))