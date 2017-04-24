import pickle
import os
import random

def load_scores(scoresFileName):
    if os.path.exists(scoresFileName):
        with open(scoresFileName, 'rb') as file:
            depickler = pickle.Unpickler(file)
            scores = depickler.load()
    else:
        scores = {}
    return scores

def save_scores(scoresFileName, scores):
    with open(scoresFileName, 'wb') as file:
        pickler = pickle.Pickler(file)
        pickler.dump(scores)

def askUserName():
    return input("Name ?: ")

def selectWord(wordList):
    return random.choice(wordList)

def searchWord(selectedWord, guessingChancesNumber):
    # First implementation: always one point
    return 1

def countScore(scores, userName, newScore):
    if userName in scores:
        scores[userName] += newScore
    else:
        scores[userName] = newScore