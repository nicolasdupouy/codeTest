//
//  ZFraction.cpp
//  Chapter16-ZFraction
//
//  Created by Nicolas Dupouy on 01/05/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include "ZFraction.h"

using namespace std;

// ############################
// # Class methods definition #
// ############################
ZFraction::ZFraction(int n, int d) : m_numerateur(n), m_denominateur(d) {
    simplifyFraction();
}

void ZFraction::simplifyFraction() {
    int pgcdNumber = pgcd(m_numerateur, m_denominateur);
    m_numerateur /= pgcdNumber;
    m_denominateur /= pgcdNumber;
}

ZFraction& ZFraction::operator+=(ZFraction const& zf2) {
    m_numerateur = m_numerateur * zf2.m_denominateur + zf2.m_numerateur * m_denominateur;
    m_denominateur *= zf2.m_denominateur;
    simplifyFraction();
    
    return *this;
}

ZFraction& ZFraction::operator*=(ZFraction const& zf2) {
    m_numerateur *= zf2.m_numerateur;
    m_denominateur *= zf2.m_denominateur;
    simplifyFraction();
    
    return *this;
}

void ZFraction::toString(std::ostream& flux) const {
    flux << m_numerateur;
    if (m_denominateur != 1)
        flux << "/" << m_denominateur;
}

bool ZFraction::isGreaterThan(ZFraction const& zf2) const {
    if (m_numerateur * zf2.m_denominateur > zf2.m_numerateur * m_denominateur) {
        return true;
    }
    return false;
}

bool ZFraction::isEquals(ZFraction const& zf2) const {
    if (m_numerateur == zf2.m_numerateur
        && m_denominateur == zf2.m_denominateur) {
        return true;
    }
    return false;
}

// ####################
// # Basic operations #
// ####################
ZFraction operator+(ZFraction const& zf1, ZFraction const& zf2) {
    ZFraction copy(zf1);
    copy += zf2;
    return copy;
}

ZFraction operator*(ZFraction const& zf1, ZFraction const& zf2) {
    ZFraction copy(zf1);
    copy *= zf2;
    return copy;
}

int pgcd(int a, int b) {
    while (b != 0) {
        const int t = b;
        b = a%b;
        a = t;
    }
    return a;
}

// #########################
// # Comparison operations #
// #########################
bool operator>(ZFraction const& zf1, ZFraction const& zf2) {
    return zf1.isGreaterThan(zf2);
}

bool operator==(ZFraction const& zf1, ZFraction const& zf2) {
    return zf1.isEquals(zf2);
}

// #####################
// # Stream operations #
// #####################
ostream& operator<<(ostream& flux, ZFraction const& zf) {
    zf.toString(flux);
    return flux;
}
