#!/opt/bin/python3

import datas
import functions

def launch_pendu():
    scores = functions.load_scores(datas.scoresFileName)
    userName = functions.askUserName()
    while (userName != 'q'):
        playTurn(userName)
        userName = functions.askUserName()
    functions.save_scores(datas.scoresFileName)

def playTurn(userName):
    functions.getScoreForUser(userName)

launch_pendu()