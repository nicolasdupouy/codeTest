//
//  main.cpp
//  TP mot mystère
//
//  Created by Nicolas Dupouy on 13/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>

using namespace std;

string askMysteryWord() {
    string mot;
    cout << "Saisissez un mot:" << endl;
    cin >> mot;
    return mot;
}

string mixMysteryWord(string mysteryWord) {
    string mixedWord;
    int randomNumber;
    
    while (mysteryWord.size() != 0) {
        randomNumber = rand() % mysteryWord.length();
        //cout << "[mysteryWord] : " << mysteryWord << "[mixedWord] : " << mixedWord << endl;
        mixedWord += mysteryWord[randomNumber];
        mysteryWord.erase(randomNumber, 1);
        //cout << "[mysteryWord] : " << mysteryWord << "[mixedWord] : " << mixedWord << endl;
    }
    
    return mixedWord;
}

int main(int argc, const char * argv[])
{
    srand(time(0));
    string mysteryWord = askMysteryWord();
    string mixedWord = mixMysteryWord(mysteryWord);
    string userWord;
    cout << "mot mystérieux: " << mysteryWord << endl;
    cout << "mot mélangé: " << mixedWord << endl;
    
    do {
        cout << "Quel est-ce mot ?" << endl;
        cin >> userWord;
        
        if (userWord == mysteryWord) {
            cout << "Bravo !" << endl;
        }
        else {
            cout << "Ce n'est pas le mot." << endl;
        }
    }
    while (userWord != mysteryWord);
    return 0;
}
