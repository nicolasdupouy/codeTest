//
//  main.cpp
//  Chapter11-pointeurs
//
//  Created by Nicolas Dupouy on 24/04/2014.
//  Copyright (c) 2014 Nicolas Dupouy. All rights reserved.
//

#include <iostream>
#include <string>

using namespace std;

void testPointeurSurReference() {
    int ageUtilisateur(16);
    int *ptr(0);
    
    cout << "L'adresse de ptr vaut: " << ptr << "." << endl
    << "On ne peut pas acceder à la valeur pointee sous peine de Segmentation Fault. " << endl;
    ptr = &ageUtilisateur;
    
    cout << "La valeur est: " << *ptr << ". L'adresse est: " << ptr << "." << endl;
}

void testAllocationDynamiquePointeur() {
    int *ptrAgeUtilisateur(0);
    ptrAgeUtilisateur = new int;
    cout << "Quel est votre age ?" << endl;
    
    cin >> *ptrAgeUtilisateur;
    cout << "Votre age est "<< *ptrAgeUtilisateur << " ans." << endl;
    
    delete ptrAgeUtilisateur;
    ptrAgeUtilisateur = 0;
}

void QCM() {
    string reponseA, reponseB, reponseC;
    reponseA = "La peur des jeux de loterue.";
    reponseB = "La peur du noir";
    reponseC = "La peur des vendredi 13";
    
    cout << "Qu'est-ce que la 'kenophobie' ?" << endl;
    cout << "A) " << reponseA << endl;
    cout << "B) " << reponseB << endl;
    cout << "C) " << reponseC << endl;
    
    char reponseUtilisateur;
    cout << "Votre reponse (A,B ou C) : ";
    cin >> reponseUtilisateur;
    
    string *ptrReponseUtilisateur(0);
    switch (reponseUtilisateur) {
            case 'A':
                ptrReponseUtilisateur = &reponseA;
                break;
            
            case 'B':
                ptrReponseUtilisateur = &reponseB;
                break;
            
            case 'C':
                ptrReponseUtilisateur = &reponseC;
                break;
    }
    //cout << "Adresse ptrReponseUtilisateur = " << ptrReponseUtilisateur << endl;
    if (ptrReponseUtilisateur == 0) {
        cout << "Vous devez choisir entre A, B et C" << endl;
    }
    else {
        cout << "Votre reponse est: " << "'" << *ptrReponseUtilisateur << "'" << endl;
    }
}

int main(int argc, const char * argv[])
{
    //testPointeurSurReference();
    //testAllocationDynamiquePointeur();
    QCM();
    return 0;
}

