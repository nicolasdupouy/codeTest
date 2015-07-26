10.times do
    puts "Hello"
end


10.times do |i|
    puts "Hello #{i}"
    i.times do
        puts "World"
    end
end