puts "Nombre(s): "
nombre = gets.chomp.upcase!
puts "Apellido paterno:  "
apellido_paterno = gets.chomp.upcase!
puts "Apellido materno:  "
apellido_materno = gets.chomp.upcase!
puts "Sexo (M|H): "
sexo = gets.chomp.upcase!
puts "--Fecha de nacimiento--"
puts "Dia (dd): "
dia_nacimiento = gets.chomp
puts "Mes (mm): "
mes_nacimiento = gets.chomp
puts "Año (aaaa): "
anio_nacimiento = gets.chomp
puts "Clave de estado: "
clave_estado = gets.chomp.upcase!

curp_generada = ""
curp_generada += apellido_paterno[ apellido_paterno =~ /[B-DF-HJ-NP-TV-Z]/]
curp_generada += apellido_paterno[ apellido_paterno =~ /[AEIOU]/ ]
curp_generada += apellido_materno[ apellido_paterno =~/[B-DF-HJ-NP-TV-Z]/ ]
curp_generada += nombre[ nombre =~ /[A-Z]/ ]
curp_generada += anio_nacimiento.match(/(?<=19)[0-9]{2}/).to_s
curp_generada += mes_nacimiento+dia_nacimiento+sexo+clave_estado
m =  /(?<=[AEIOU])[B-DF-HJ-NP-TV-Z]/.match(apellido_paterno)
curp_generada += apellido_paterno[ m.end(0)-1 ]
m =  /(?<=[AEIOU])[B-DF-HJ-NP-TV-Z]/.match(apellido_materno)
curp_generada += apellido_materno[ m.end(0)-1 ]
m =  /(?<=[AEIOU])[B-DF-HJ-NP-TV-Z]/.match(nombre)
curp_generada += nombre[ m.end(0)-1 ]

caracteres_alfanumericos = %w{0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z}
numero = caracteres_alfanumericos.length

curp_generada += caracteres_alfanumericos[rand(numero)] + rand(10).to_s

puts "Su CURP es: #{curp_generada}"

puts "--Comprobacion de la CURP--"
#Comprobacion de la curp
regex_curp = /[A-Z][AEIOU][A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[0-9]|[1-2][0-9]|3[0-1])[MH][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z][0-9]/
m1 = regex_curp.match curp_generada
puts m1
puts m1.class
m2 = curp_generada =~ regex_curp
puts m2