//
//  Arme.h
//  Chapters13-14-Classes
//
//  Created by Nicolas Dupouy on 28/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#ifndef __Arme__
#define __Arme__

#include <iostream>

class Arme {
private:
    std::string m_nom;
    int m_degats;
    
public:
    Arme();
    Arme(std::string nom, int degats);
    void changer(std::string nom, int degats);
    void afficher() const;
    int getDegats() const;
};

#endif /* defined(__Arme__) */
