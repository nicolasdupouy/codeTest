import pickle
import os

def load_scores(scoresFileName):
    if os.path.exists(scoresFileName):
        with open(scoresFileName, 'rb') as file:
            depickler = pickle.Unpickler(file)
            return depickler.load()

def save_scores(scores_file_name):
    print(save_scores)

def askUserName():
    return input("Name ?: ")

def getScoreForUser(userName):
    print(getScoreForUser)
    print(userName)