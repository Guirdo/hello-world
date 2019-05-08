def q_1(cadena,contador)
    if cadena[contador].match /[A-Za-z]/
        contador+=1
        q_2(cadena,contador,3)
        return true
    else
        return false
    end
end

def q_2 (cadena,contador,i)
    if cadena[contador].match /[A-Za-z]/

    else

    end
end

contador = 0

print "Introduce un RFC: "
cadena = gets.chomp

puts "Este es el RFC que introdujiste: #{cadena}"

puts mensaje = q_1(cadena,contador) ? "Si es una letra" : "No es una letra"

