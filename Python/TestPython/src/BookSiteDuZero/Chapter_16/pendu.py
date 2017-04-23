#!/opt/bin/python3

import datas
import functions

def launch_pendu():
    functions.load_scores()
    userName = functions.askUserName()
    while (userName != 'q'):
        playTurn(userName)
        userName = functions.askUserName()
    functions.save_scores()

def playTurn(userName):
    functions.getScoreForUser(userName)

launch_pendu()