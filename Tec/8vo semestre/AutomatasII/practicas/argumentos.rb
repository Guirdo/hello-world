def metodo arg1="Diba",arg2="Shack",arg3="Shank"
    "#{arg1}, #{arg2}, #{arg3}"
end

#Numero de argumentos variables
def foo *mi_string
    mi_string.each do |palabras|
        puts palabras
    end
end

puts "¿En que ciudad vives?"

STDOUT.flush
ciudad = gets.chomp
puts "La ciudad es #{ciudad}"

#Escribe un programa que pregunte la temperatura en Faren,
# el programa usara este dato y hallara el equivalente en C y K
#El resultado final lo mostrara con dos decimales