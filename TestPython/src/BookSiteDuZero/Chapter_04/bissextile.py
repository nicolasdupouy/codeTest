#!/usr/bin/python3
# -*-coding:Latin-1 -*
#import os
#print("Hello the world !")
#input("Press enter to close this program ...")
#os.system("sleep 5")

annee = input("Entrez l\'année à tester:")
annee = int(annee)

if annee % 400 == 0 or (annee % 4 == 0 and annee % 100 != 0):
    print("""L'année saisie est bissextille.""")
else:
    print("""L'année saisie n'est pas bissextille.""")
        
#print("année : ", annee)