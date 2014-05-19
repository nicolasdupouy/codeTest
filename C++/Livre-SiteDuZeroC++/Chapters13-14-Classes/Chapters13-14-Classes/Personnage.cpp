//
//  Personnage.cpp
//  Chapters13-14-Classes
//
//  Created by Nicolas Dupouy on 26/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include "Personnage.h"
#include "Arme.h"
#include <string>

using namespace std;

Personnage::Personnage() : m_vie(100), m_mana(100), m_arme("Epée rouillée", 10)
{
    /*m_vie = 100;
    m_mana = 100;
    m_nomArme = "Epée rouillée";
    m_degatArme = 10;*/
}

Personnage::Personnage(string nomArme, int degatsArme) : m_vie(100), m_mana(100), m_arme(nomArme, degatsArme) {}

void Personnage::recevoirDegats(int nbDegats) {
    m_vie -= nbDegats;
    if (m_vie < 0) {
        m_vie = 0;
    }
}

void Personnage::attaquer(Personnage &cible) {
    cible.recevoirDegats(m_arme.getDegats());
}

void Personnage::boirePotionDeVie(int quantitePotion) {
    m_vie += quantitePotion;
    if (m_vie > 100) {
        m_vie = 100;
    }

}

void Personnage::changerArme(string nomNouvelleArme, int degatsNouvelleArme) {
    m_arme.changer(nomNouvelleArme, degatsNouvelleArme);}

bool Personnage::estVivant() const {
    return (m_vie > 0);
}

void Personnage::afficherEtat() const {
    cout << "Vie = " << m_vie << " / Mana = " << m_mana << endl;
    
}