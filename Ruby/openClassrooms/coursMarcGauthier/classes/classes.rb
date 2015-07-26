class Utilisateur
    attr_accessor :prenom, :nom
    
end

bob = Utilisateur.new
bob.prenom = "Bob"
bob.nom = "Lenon"

jane = Utilisateur.new
jane.prenom = "Jane"
jane.nom = "Lenon"

puts bob 
puts bob.class
puts bob.prenom + " " + bob.nom
puts jane.prenom + " " + jane.nom