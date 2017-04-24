#!/opt/bin/python3

import datas
import functions

def launch_pendu():
    scores = functions.load_scores(datas.scoresFileName)
    userName = "nicolas" #functions.askUserName()
    while (userName != 'q'):
        iterate(userName, scores)
        userName = functions.askUserName()

def iterate(userName, scores):
    selectedWord = functions.selectWord(datas.wordList)
    newScore = functions.searchWord(selectedWord, datas.guessingChancesNumber)
    functions.countScore(scores, userName, newScore)
    functions.save_scores(datas.scoresFileName, scores)

launch_pendu()
