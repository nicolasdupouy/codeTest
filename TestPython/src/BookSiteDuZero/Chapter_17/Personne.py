'''
Created on May 10, 2013

@author: nicolas
'''

class Personne:
    '''
    Classe définissant une personne caractérisée par:
    - son nom
    - son prénom
    - son age
    '''


    def __init__(self, nom, prenom, age):
        '''
        Constructor
        '''
        self.nom = nom
        self.prenom = prenom
        self.age = age
        