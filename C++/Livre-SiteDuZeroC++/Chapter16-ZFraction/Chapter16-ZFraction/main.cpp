//
//  main.cpp
//  Chapter16-ZFraction
//
//  Created by Nicolas Dupouy on 01/05/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include <iostream>
#include "ZFraction.h"

using namespace std;

int main(int argc, const char * argv[])
{
    ZFraction a(4,5);
    ZFraction b(2);
    ZFraction c,d;
    
    c = a+b;
    d = a*b;
    
    cout << a << " + " << b << " = " << c << endl;
    cout << a << " * " << b << " = " << d << endl;
    
    if (a > b) {
        cout << "a est plus grand que b." << endl;
    }
    else if (a == b) {
        cout << "a est égal à b." << endl;
    }
    else {
        cout << "a est plus petit que b." << endl;
    }
    
    ZFraction e(6,5);
    cout << a << " + " << e << " = " << a + e << endl;
    return 0;
}

