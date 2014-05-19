//
//  ZFraction.h
//  Chapter16-ZFraction
//
//  Created by Nicolas Dupouy on 01/05/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#ifndef __ZFraction__
#define __ZFraction__

#include <iostream>

class ZFraction {
private:
    int m_numerateur;
    int m_denominateur;
    
    void simplifyFraction();
    
public:
    ZFraction(int n = 0, int d = 1);
    
    ZFraction& operator+=(ZFraction const& zf2);
    ZFraction& operator*=(ZFraction const& zf2);
    
    void toString(std::ostream& flux) const;
    bool isGreaterThan(ZFraction const& zf2) const;
    bool isEquals(ZFraction const& zf2) const;
};

// ####################
// # Basic operations #
// ####################
ZFraction operator+(ZFraction const& zf1, ZFraction const& zf2);
ZFraction operator*(ZFraction const& zf1, ZFraction const& zf2);

int pgcd(int a, int b);

// #########################
// # Comparison operations #
// #########################
bool operator>(ZFraction const& zf1, ZFraction const& zf2);
bool operator==(ZFraction const& zf1, ZFraction const& zf2);

// #####################
// # Stream operations #
// #####################
std::ostream& operator<<(std::ostream& flux, ZFraction const& zf);

#endif /* defined(__ZFraction__) */
