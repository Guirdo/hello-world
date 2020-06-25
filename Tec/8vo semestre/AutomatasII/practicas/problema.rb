=begin
Problema del tablero de ajedrez

Si ponemos un grano y duplicamos en la siguiente y 
así hasta rellenar el tablero, cuantos granos tendremos?

=end

granos = 1

64.times do |escaque|
puts "En el escaque #{escaque+1} hay #{granos}"
granos *= 2
end