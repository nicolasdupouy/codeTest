//
//  Personnage.h
//  Chapters13-14-Classes
//
//  Created by Nicolas Dupouy on 26/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#ifndef __Personnage__
#define __Personnage__

#include <iostream>
#include <string>
#include "Arme.h"

class Personnage {
private:
    int m_vie;
    int m_mana;
    Arme m_arme;
    
public:
    Personnage();
    Personnage(std::string nomArme, int degatsArme);
    void recevoirDegats(int nbDegats);
    void attaquer(Personnage &cible);
    void boirePotionDeVie(int quantitePotion);
    void changerArme(std::string nomNouvelleArme, int degatsNouvelleArme);
    bool estVivant() const;
    void afficherEtat() const;
};

#endif /* defined(__Personnage__) */
