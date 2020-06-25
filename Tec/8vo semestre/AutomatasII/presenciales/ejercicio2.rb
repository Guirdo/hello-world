puts "Introduzca el numero de elementos"
tamano = gets.chomp.to_i

vec = []

tamano.times do |num|
    puts "Introduzca el elemento ##{num+1}"
    vec[num] = gets.chomp.to_i
end

suma = 0

vec.each do |elemento|
    suma += elemento
end

puts "La suma de los elementos del array es: #{suma}"



        puts "Hello world!"