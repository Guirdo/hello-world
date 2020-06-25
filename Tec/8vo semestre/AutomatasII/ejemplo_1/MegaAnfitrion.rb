class MegaAnfitrion

	attr_accessor :nombres

	def initialize nombres="Mundo"
		@nombres = nombres
	end
	
	def decir_hola 
		if @nombres.nil?
			puts "Nombre vacio"
		elsif @nombres.respond_to?("each")
			@nombres.each do |nombre|
				puts "Hola #{nombre}"
			end
		else
			puts "Hola #{@nombres}"
		end
	end
	
	def decir_adios
		if @nombres.nil?
			puts "..."
		elsif @nombres.respond_to?("join")
			puts "Adios #{@nombres.join("-")}. Vuelvan pronto"
		else
			puts "Adios #{@nombres}"
		end
	end

end

persona1 = MegaAnfitrion.new()
persona1.decir_hola
persona1.decir_adios

persona1 = MegaAnfitrion.new("Aldo")
persona1.decir_hola
persona1.decir_adios

persona1 = MegaAnfitrion.new(["Susana","Diana","Victor"])
persona1.decir_hola
persona1.decir_adios