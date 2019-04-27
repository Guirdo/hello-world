def hola_gente(mensaje,*personas)
    personas.each { |persona| puts "#{mensaje} #{persona}"}
end

nombres = ["Aldo","Coco","Ramiro"]

hola_gente("Hola",*nombres)