var age = parseInt( prompt("Veuillez entrer votre age svp."), 10 );

var ageNegatif = "Votre age ne peut pas être négatif";
var age1_17 = "Vous n'êtes pas encore majeur";
var age18_49 = "Vous êtes majeur mais pas encore senior";
var age50_59 = "Vous êtes senior mais pas encore retraité";
var age60_120 = "Vous êtes retraité, profitez de votre temps libre !";
var casNonGere = "Cas non géré";
var ageNonSaisi = "Vous n'avez pas entré d'âge";

if (age <= 0) {
    alert(ageNegatif);
}
else if (age >= 1 && age <= 17) {
    alert(age1_17);
}
else if (age >= 18 && age <= 49) {
    alert(age18_49);
}
else if (age >= 50 && age <= 59) {
    alert(age50_59);
}
else if (age >= 60 && age <= 120) {
    alert(age60_120);
}
else if (age > 120) {
    alert(casNonGere);
}
else {
    alert(ageNonSaisi);
}
