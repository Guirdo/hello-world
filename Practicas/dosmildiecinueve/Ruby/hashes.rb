tutor = {nombre: "Aldo",
        edad: 21,
        cursos: 1}

tutor.each do |clave,valor|
    puts "En #{clave} esta guardado #{valor}"
end