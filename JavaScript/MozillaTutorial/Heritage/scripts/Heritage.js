function Personne(prenom, nom, age, genre, interets) {
  this.nom = {
    prenom,
    nom
  };
  this.age = age;
  this.genre = genre;
  this.interets = interets;
};


function Professeur(prenom, nom, age, genre, interets, matiere) {
    Personne.call(this, prenom, nom, age, genre, interets);
  
    this.matiere = matiere;
  }
