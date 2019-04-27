# IO = Input/Output

# Este programa recibe un nombre y lo imprime
print "Introduce tu nombre: "
# Gets obtiene por consola
nombre = gets
# Gets obtiene tambien el salto de linea invisible
nombre = nombre.chomp.capitalize

puts "¡Hola #{nombre}!"
puts "#{nombre} tiene #{nombre.length} letras"