=begin
    
rescue => exception
    
end
vec1=[]

nombres = ['Juan','Pedro','Raul','Joel']

puts nombres[0]
puts nombres[1]
puts nombres[2]
puts nombres[3]
puts nombres[4]

nombres[3]="Ruby"
nombres[4] = "Java"

puts nombres[3]
puts nombres[4]
=end

=begin
sabor = "mango"
vector = [80.5,sabor,[true,false]]

puts vector
=end

=begin

nombres1 = ['Juan','Pedro','Raul']
nombres2 = %w{Juan Pedro Raul}

puts nombres1
puts nombres2

ESCRIBE UN PROGRAMA TAL QUE DADO UN ARRAY NUMERICO, CALCULE LA SUMA
DE SUS ELEMENTOS

=end

ciudades = %w{Pune Mumbai Bangalone}
ciudades.each do |ciudad|
    puts ciudad
end

ciudades.delete('Mumbai')

ciudades.each do |ciudad|
    puts ciudad
end
