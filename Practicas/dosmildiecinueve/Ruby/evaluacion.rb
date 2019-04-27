print "Introduce tu calificacion: "
calificacion = gets.chomp.to_i

puts case calificacion 
when 10,9 
    "Muy bien"
when 8 
    "Aun puedes mejorar"
when 7 
    "Ahi vas"
when 6 
    "Ya date de baja... pero de la vida"
else 
    "Ya ni vengas, mejor"
end