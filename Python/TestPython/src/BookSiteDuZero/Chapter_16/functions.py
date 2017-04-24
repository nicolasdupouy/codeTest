import pickle
import os
import random

def load_scores(scoresFileName):
    if os.path.exists(scoresFileName):
        with open(scoresFileName, 'rb') as file:
            depickler = pickle.Unpickler(file)
            scores = depickler.load()
            file.close()

    else:
        scores = {}
    return scores

def save_scores(scoresFileName, scores):
    with open(scoresFileName, 'wb') as file:
        pickler = pickle.Pickler(file)
        pickler.dump(scores)
        file.close()

def askUserName():
    return input("Name ?: ")

def selectWord(wordList):
    return random.choice(wordList)

def searchWord(selectedWord, guessingChancesNumber):
    # First implementation: always one point
    triesLeft = guessingChancesNumber
    print("You have ", triesLeft, " tries to find the letters: ")

    wordFound = False
    lettersFound = []
    while(triesLeft > 0 and wordFound==False):
        letter = input("Letter: ")
        if (letter not in selectedWord):
            print("The letter", letter, " is not in this word")
            triesLeft -= 1
        else:
            lettersFound.append(letter)

        displayWordToUser(triesLeft, selectedWord, lettersFound)
        wordFound = isWordFound(selectedWord, lettersFound)

    return triesLeft

def displayWordToUser(triesLeft, selectedWord, lettersFound):
    wordToDisplay = getWordWithX(selectedWord, lettersFound)
    print("Word: ", wordToDisplay, " / tries left: ", triesLeft)

def isWordFound(selectedWord, lettersFound):
    wordFound = True
    for letter in selectedWord:
        if letter not in lettersFound:
            wordFound = False

    return wordFound

def getWordWithX(selectedWord, lettersFound):
    wordWithX = ""
    for letter in selectedWord:
        if letter in lettersFound:
            wordWithX += letter
        else:
            wordWithX += 'X'
    return wordWithX

def countScore(scores, userName, newScore):
    if userName in scores:
        scores[userName] += newScore
    else:
        scores[userName] = newScore
    print("The new score for ", userName, " is ", scores[userName], ".")