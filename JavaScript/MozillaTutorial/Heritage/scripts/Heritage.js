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

Professeur.prototype.saluer = function() {
  var prefix;

  if (this.genre === 'mâle' || this.genre === 'Mâle' || this.genre === 'm' || this.genre === 'M') {
    prefix = 'M.';
  } else if (this.genre === 'femelle' || this.genre === 'Femelle' || this.genre === 'f' || this.genre === 'F') {
    prefix = 'Mme';
  } else {
    prefix = '';
  }

  alert('Bonjour. Mon nom est ' + prefix + ' ' + this.nom.nom + ', et j\'enseigne ' + this.matiere + '.');
}