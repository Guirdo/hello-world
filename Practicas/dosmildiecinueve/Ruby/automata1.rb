=begin
    Ejemplo de automata finito determinista.

    Lenguaje = Toda cadena que empiece con '0'

=end

# Q1
def q_1(cadena,contador)
    if cadena[contador] == '0'
        puts cadena[contador]
        q_2(cadena,contador+1)
        return true;
    else
        puts cadena[contador] 
        q_3(cadena,contador+1)
        return false
    end

end

def q_2(cadena,contador)
    if contador == cadena.length-1
        puts cadena[contador]
        return 
    else
        puts cadena[contador]
        q_2(cadena,contador+1)
    end
end

def q_3(cadena,contador)
    if contador == cadena.length-1
        puts cadena[contador]
        return
    else
        puts cadena[contador]
        contador+=1
        q_3(cadena,contador+1)
    end
end


# Parte principal
contador = 0

# Zona de entrada
print "Introduce una cadena: "
cadena = gets.chomp

puts mensaje = q_1(cadena,contador) ? "Cadena aceptada" : "Cadena no aceptada"