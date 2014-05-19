//
//  main.cpp
//  Chapters13-14-Classes
//
//  Created by Nicolas Dupouy on 26/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include <iostream>
#include "Personnage.h"

using namespace std;
int main(int argc, const char * argv[])
{
    Personnage david, goliath("Epée aiguisée", 20);
    
    goliath.attaquer(david);
    david.boirePotionDeVie(20);
    goliath.attaquer(david);
    david.attaquer(goliath);
    
    goliath.changerArme("Double hache tranchante vénéneuse de la mort", 40);
    goliath.attaquer(david);
    
    cout << "David: ";
    david.afficherEtat();
    cout << "Goliath: ";
    goliath.afficherEtat();
    return 0;
}

