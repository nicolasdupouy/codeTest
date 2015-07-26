class Animal
  attr_accessor :nom
  
  def initialize(nom)
    @nom = nom
  end
  
  def parler
    puts "Je suis un animal qui s'appelle #{nom}"
  end
end

class Chien < Animal
  def parler
    puts "#{nom}: Ouaf !"
  end
end

class Chat < Animal
  def parler
    puts "#{nom}: Miaou !"
  end
end

class Oiseau < Animal
end

mon_chien = Chien.new("Bob le chien")
mon_chat = Chat.new("Adeline le chat")
mon_oiseau = Oiseau.new("oiseau")


mon_chat.parler
mon_chien.parler
mon_oiseau.parler