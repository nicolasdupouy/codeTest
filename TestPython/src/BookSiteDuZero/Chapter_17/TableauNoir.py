'''
Created on May 11, 2013

@author: nicolas
'''

class TableauNoir:
    '''
    Classe définissant une surface sur laquelle on peut écrire,
    que l'on peut lire et effacer.
    '''


    def __init__(self):
        '''
        Constructor
        '''
        self.surface = ""
    
    
    def ecrire(self, message):
        '''
        Ecrire sur le tableau. Si le tableau n'est pas vide, 
        on sautera une ligne.
        '''
        if self.surface != "":
            self.surface += "\n"
        self.surface += message
    
    def lire(self):
        '''
        Afficher le contenu du tableau.
        '''
        print(self.surface)
        
    
    def effacer(self):
        '''
        Effacer le tableau.
        '''
        self.surface = ""
    