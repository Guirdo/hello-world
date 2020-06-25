class Perdido

def method_missing m,*args
	puts "No existe el metodo #{m}"
end

end

Perdido.new.hola