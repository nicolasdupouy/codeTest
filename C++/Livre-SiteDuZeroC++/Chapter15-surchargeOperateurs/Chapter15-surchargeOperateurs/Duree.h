//
//  Duree.h
//  Chapter15-surchargeOperateurs
//
//  Created by Nicolas Dupouy on 28/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#ifndef __Duree__
#define __Duree__

#include <iostream>

class Duree {
private:
    int m_heure;
    int m_minute;
    int m_seconde;
public:
    Duree(int heure = 0, int minute = 0, int seconde = 0);
    Duree& operator+=(Duree const& d2);
    Duree& operator+=(int secondes);
    
    void afficher(std::ostream& flux) const;
    bool isEqual(Duree const& d2) const;
    bool isLower(Duree const& d2) const;
};

// Addition
Duree operator+(Duree const& d1, Duree const& d2);
Duree operator+(Duree const& d1, int secondes);

// Comparaison
bool operator==(Duree const& d1, Duree const& d2);
bool operator!=(Duree const& d1, Duree const& d2);
bool operator<(Duree const& d1, Duree const& d2);

// Flux
std::ostream& operator<<(std::ostream& flux, Duree const& d);

#endif /* defined(__Duree__) */
