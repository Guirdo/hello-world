print "Introduce un numero: "
numero = gets.chomp
numero = numero.to_i

residuo = numero % 2

mensaje =  if residuo == 0
    "#{numero} es par!"
else
    "#{numero} es impar!"
end

puts mensaje

