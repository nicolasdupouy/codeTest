//
//  Arme.cpp
//  Chapters13-14-Classes
//
//  Created by Nicolas Dupouy on 28/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include <iostream>
#include "Arme.h"

using namespace std;

Arme::Arme() : m_nom("Epée rouillée"), m_degats(10) {}

Arme::Arme(std::string nom, int degats) : m_nom(nom), m_degats(degats) {}

void Arme::changer(std::string nom, int degats) {
    m_nom = nom;
    m_degats = degats;
}

void Arme::afficher() const {
    cout << "Arme : " << m_nom << " (Degats: " << m_degats << ")" << endl;
}

int Arme::getDegats() const {
    return m_degats;
}