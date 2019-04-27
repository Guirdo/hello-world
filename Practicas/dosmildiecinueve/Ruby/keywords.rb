def hola(nombre: "Anonimo", edad:0)
    if edad >= 30
        puts "Hola señor #{nombre}"
    elsif edad < 30
        puts "Hola joven #{nombre}"
    end
end

hola(edad: 31)