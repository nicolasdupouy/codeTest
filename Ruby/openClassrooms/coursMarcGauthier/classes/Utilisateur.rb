class Utilisateur
    attr_accessor :prenom, :amis

    def initialize(prenom)
        @prenom = prenom
    end
    
    def est_ami_avec?(autreUtilisateur)
        #[amis].include?(autreUtilisateur)
        amis.each do |ami|
            return autreUtilisateur == ami
        end
        return false
    end
end

alice = Utilisateur.new("Alice")
bob = Utilisateur.new("Bob")
jane = Utilisateur.new("Jane")

alice.amis = [bob, jane]
bob.amis = [alice, jane]
jane.amis = [alice, bob]

puts "Nombre d'amis d'" + alice.prenom + ":"
puts alice.amis.size
puts "Alice est amie avec bob ?"
puts alice.est_ami_avec?(bob)