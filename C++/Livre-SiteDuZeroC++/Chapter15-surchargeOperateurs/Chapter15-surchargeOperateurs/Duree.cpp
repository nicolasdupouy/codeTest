//
//  Duree.cpp
//  Chapter15-surchargeOperateurs
//
//  Created by Nicolas Dupouy on 28/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include "Duree.h"
#include <iostream>

using namespace std;

Duree::Duree(int heure, int minute, int seconde) : m_heure(heure), m_minute(minute), m_seconde(seconde) {}

Duree& Duree::operator+=(Duree const& d2) {
    m_seconde += d2.m_seconde;
    m_minute += m_seconde / 60;
    m_seconde %= 60;
    
    m_minute += d2.m_minute;
    m_heure += m_minute / 60;
    m_minute %= 60;
    
    m_heure += d2.m_heure;
    
    return *this;
}

Duree& Duree::operator+=(int secondes) {
    Duree duree(0, 0, secondes);
    *this += duree;
    
    return *this;
}

void Duree::afficher(ostream& flux) const {
    flux << m_heure << "h" << m_minute << "m" << m_seconde << "s";
}

bool Duree::isEqual(Duree const& d2) const {
    if (m_heure == d2.m_heure
        && m_minute == d2.m_minute
        && m_seconde == d2.m_seconde) {
        return true;
    }
    return false;
}

bool Duree::isLower(Duree const& d2) const {
    if (m_heure < d2.m_heure) {
        return true;
    }
    if (m_minute < d2.m_minute) {
        return true;
    }
    if (m_seconde < d2.m_seconde) {
        return true;
    }
    return false;
}

// Addition
Duree operator+(Duree const& d1, Duree const& d2) {
    Duree result(d1);
    result += d2;
    
    return result;
}

Duree operator+(Duree const& d1, int secondes) {
    Duree result(d1);
    result += secondes;
    
    return result;
}

// Comparaison
bool operator==(Duree const& d1, Duree const& d2) {
    return d1.isEqual(d2);
}

bool operator!=(Duree const& d1, Duree const& d2) {
    return !d1.isEqual(d2);
}

bool operator<(Duree const& d1, Duree const& d2) {
    return d1.isLower(d2);
}

// Flux
ostream& operator<<(ostream& flux, Duree const& d) {
    d.afficher(flux);
    return flux;
}
