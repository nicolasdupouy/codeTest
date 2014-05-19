//
//  main.cpp
//  Chapter15-surchargeOperateurs
//
//  Created by Nicolas Dupouy on 28/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include <iostream>
#include "Duree.h"

using namespace std;

int main(int argc, const char * argv[])
{

    Duree duree1(0, 10, 28), duree2(0, 15, 2), duree3(1, 36, 32);
    
    cout << duree1 << " + " << duree2 << " + " << duree3
         << " + 45 secondes"
         << " = " << duree1 + duree2 + duree3 + 45
         << endl << endl;
    
    duree1 += duree2;
    cout << duree1 << endl;
    
    if (duree2 < duree3) {
        cout << "duree2 is lower than duree3" << endl;
    }
    else {
        cout << "duree2 is lower than duree3" << endl;
    }
    
    Duree duree4(1, 51, 34);
    cout << "duree4 = " << duree4 << endl;
    cout << "duree2 + duree3 = " << duree2 + duree3 << endl;
    cout << "duree2 + duree3 + 10 = " << duree2 + duree3 + 10 << endl;
    if (duree4 == duree2 + duree3) {
        cout << "duree4 est égale à duree2 + duree3" << endl;
    }
    if (duree4 != duree2 + duree3 + 10) {
        cout << "duree4 n'est pas égale à duree2 + duree3 + 10 secondes" << endl;
    }
    
    return 0;
}

