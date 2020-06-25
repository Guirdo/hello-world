puts "Introduzca la temperatura en Fahrenheit: "
STDOUT.flush
fahrenheit = gets.chomp.to_f

c = (fahrenheit-32)*5/9
k = c+273.15

puts "F° a C°: #{c.round(2)}"
puts "F° a K°: #{k.round(2)}"
