#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on 17 mars 2013

@author: nicolasdupouy
'''

from random import randrange
from math import ceil


def select_mise(miseMaximum):
    """Fonction de sélection de la mise"""
    print("mise maximum = ", miseMaximum)
    sommeSaisie = input("Entrez la somme misée: ")
    sommeSaisie = int(sommeSaisie)
    if (sommeSaisie > miseMaximum):
        print("La mise est limitée au restant de la cagnotte:", miseMaximum)
        return miseMaximum
    else:
        return sommeSaisie
    
    
def select_number():
    """Fonction demandant la sélection d'un nombre"""
    try:
        choosedNumber = input("Saisissez un nombre entre 0 et 49: ")
        choosedNumber = int(choosedNumber)
        if (choosedNumber < 0 or choosedNumber > 50):
            raise ValueError("Le nombre doit être comprit entre 0 et 49 inclus.")
    except ValueError as ve:
        print("Erreur: ", ve)
    else:
        return choosedNumber


def computeCoeff(choosedNumber):
    """Fonction déterminant le coefficient multiplicateur à appliquer
    dans le cadre de ce jeu."""
    randomNumber = randrange(50)
    randomNumber = int(randomNumber)
    print("Le nombre random est ", randomNumber)
    if randomNumber == choosedNumber:
        return 3
    elif isBothEvenOrOdd(randomNumber, choosedNumber):
        return 0.5
    else:
        return 0


def isBothEvenOrOdd(number_one, number_two):
    """Fonction qui détermine si les deux nombres sont pairs simultanément
    ou impairs simultanément."""
    if number_one % 2 == number_two % 2:
        return True
    else:
        return False
    
    
def launch_roulette(mise):
    
    choosedNumber = select_number()
    print("Le nombre choisit est: ", choosedNumber)
    print("\n")
    
    coefficientMultiplicateur = computeCoeff(choosedNumber)
    print("## coefficientMultiplicateur = ", coefficientMultiplicateur, "##")
    
    return ceil(coefficientMultiplicateur * mise)
    #print("Somme finale = ", sommeFinale)


def stopOuEncore():
    continuer = input("Continuer (Y/N)")
    if (continuer == "Y"):
        return True
    else:
        return False
    
    

def launch_casino():
    capital = 1000
    continuer = True

    while (capital > 0 and continuer):
        mise = select_mise(capital)
        sommeFinale = launch_roulette(mise)
        print("## mise        = ", mise)
        print("## sommeFinale = ", sommeFinale)
        capital = capital - mise + sommeFinale
        print("## Capital = ", capital)
        if (capital <= 0):
            continue
        continuer = stopOuEncore()
        print("\n\n")
        
    print("Fin de la partie.")
    print("Votre capital est de: ", capital)
    
    
    
    
if __name__ == '__main__':
    launch_casino()
    
    