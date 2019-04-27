canciones = ["Five Years","Starman","Panico","Date cuenta"]

reproduciendo = true

index_cancion = 0

#Si hay canciones en la lista de reproduccion y se esta reproduciendo
# entonces ejecutar ciclo

while (index_cancion < canciones.length) && reproduciendo
    puts "Reproduccionendo #{canciones[index_cancion]}"
    index_cancion += 1

    puts "Detener (0)"
    respuesta = gets.chomp.to_i

    reproduciendo = respuesta != 0
end