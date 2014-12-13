'''
Created on May 9, 2013

@author: nicolas
'''
import pickle # R/W in the scores file
from datas import *
import os

#def pick_name():
#    player_name = input("Nom du joueur: ")
#    
#    return player_name

# Scores functions:
# -----------------
def load_scores():
    if os.path.exists(scores_file_name):
        with open(scores_file_name, "rb") as fichier:
            nom_depickler = pickle.Unpickler(fichier)
            scores = nom_depickler.load()
    else:
        scores = {}
    return scores
    
def store_scores(player_name, score):
    scoresDict = load_scores()
    
    if player_name in scoresDict:
        scoresDict[player_name] += score
    else:
        scoresDict[player_name] = score
    #final_scores = {player_name: score}
    
    with open(scores_file_name, 'wb') as fichier:
        nom_pickler = pickle.Pickler(fichier)
        nom_pickler.dump(scoresDict)
    

# xxxxxx:
# -----------------

