#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

def decomposer(entier, divise_par):
    """Cette fonction retourne la partie entière et le reste de 
    entier / divise_par"""
    p_e = entier // divise_par
    reste = entier % divise_par
    return p_e, reste

if __name__ == '__main__':
    partie_entiere, reste = decomposer(20,3)
    print("partie_entiere = " + str(partie_entiere))
    print("reste = " + str(reste))
