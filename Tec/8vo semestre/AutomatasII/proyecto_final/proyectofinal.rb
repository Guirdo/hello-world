require 'fox16'
include Fox

class Ventana < FXMainWindow
    
    attr_accessor :cargarArchivo, :archivo,:dialogo,:analizar,:tabla1,:tabla2

    def initialize(app)
        super(app,"Compilador Fase 1 - Analizador léxico",:width=>650,:height=>600)
        
        @archivo = FXText.new(self, :opts => LAYOUT_EXPLICIT,:x=>10,:y=>10,:height=>300,:width=>250)
        @cargarArchivo = FXButton.new(self,"Cargar archivo",:opts => LAYOUT_EXPLICIT,:x=>270,:y=>10,:height=>20,:width=>100)
        @analizar = FXButton.new(self,"Analizar",:opts => LAYOUT_EXPLICIT,:x=>270,:y=>40,:height=>20,:width=>100)

        @tabla1 = FXTable.new(self,:opts => LAYOUT_EXPLICIT,:x=>380,:y=>10,:height=>300,:width=>250)
        @tabla1.setTableSize(0,2)
        @tabla1.setColumnWidth(0,120)
        @tabla1.setColumnWidth(1,120)
        @tabla1.setColumnText(0,"Token")
        @tabla1.setColumnText(1,"Lexema")
        @tabla1.rowHeaderMode = LAYOUT_FIX_WIDTH
        @tabla1.rowHeaderWidth = 0

        @tabla2 = FXTable.new(self, :opts => LAYOUT_EXPLICIT,:x=>10,:y=>320,:width=>500,:height=>300)
        @tabla2.setTableSize(11,2)
        @tabla2.setColumnWidth(0,250)
        @tabla2.setColumnWidth(1,250)
        @tabla2.rowHeaderMode = LAYOUT_FIX_WIDTH
        @tabla2.rowHeaderWidth = 0
        @tabla2.setColumnText(0,"Tokens")
        @tabla2.setColumnText(1,"Cantidad")
        @tabla2.setItemText(0,0,"Palabras reservadas")
        @tabla2.setItemText(1,0,"Operadores")
        @tabla2.setItemText(2,0,"Identificadores")
        @tabla2.setItemText(3,0,"Cadenas")
        @tabla2.setItemText(4,0,"Numeros")
        @tabla2.setItemText(5,0,"Caracter")
        @tabla2.setItemText(6,0,"Parentesis")
        @tabla2.setItemText(7,0,"Llaves")
        @tabla2.setItemText(8,0,"Corchetes")
		@tabla2.setItemText(9,0,"Punto y coma")
		@tabla2.setItemText(10,0,"Metodos")

        @dialogo = FXFileDialog.new(self,"Cargar archivo")
        @dialogo.selectMode = SELECTFILE_EXISTING
    end

    def create
        super
        show(PLACEMENT_SCREEN)
    end
end

## Principal
@texto = ""
app = FXApp.new
@main = Ventana.new(app)

# Acciones de los botones
@main.cargarArchivo.connect(SEL_COMMAND) do
    # Abre un dialogo para abrir un archivo java
    if (@main.dialogo.execute != 0)
        # limpia el FXText antes de mostrar otro archivo distinto
        @main.archivo.removeText(0,@main.archivo.length)

        #Va leyendo cada linea del archivo seleccionado
        File.foreach(@main.dialogo.filename) do |line|
            @main.archivo.appendText(line) #La agrega al FXText
            @texto += line
        end
    end
end

@main.analizar.connect(SEL_COMMAND) do
		# Patron para analizar el archivo java
		patron = /(public|class|static|void|Stringabstract|assert|boolean|break|byte|case|catch|char|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|null|package|private|protetec|return|short|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while)|([^\.][+-\/%<=>]|[*]|<=|>=|==|!=|[|]{2}|&&)|([A-Za-z][\w]*)|("[\w\s]*")|([0-9]+\.[0-9]+|[0-9]+)|(['].['])|([\(]|[\)])|([{]|[}])|([\[]|[\]])|([;])|(\.[\w]+)/
		
		# Contadores
		reservada = 0
		operador = 0
		identificador = 0
		cadena = 0
		numeros = 0
		caracteres = 0
		parentesis = 0
		llaves = 0
		corchetes = 0
		puntocoma = 0
		metodos = 0
		
		i = 0 # Contador para la tabla
		@texto.scan(patron).each do |m|
			if(m[0] != nil)
				reservada += 1
				@main.tabla1.appendRows() # Agrega una fila a la tabla
				@main.tabla1.setItemText(i,0,"Palabra reservada") # Pone el nombre del token en la primera columna
				@main.tabla1.setItemText(i,1,m[0]) # Pone el lexema en la segunda columna
				i+=1 # Va aumentando segun la fila que se agrega
			elsif (m[1] != nil)
				operador += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Operador")
				@main.tabla1.setItemText(i,1,m[1])
				i+=1
			elsif (m[2] != nil)
				identificador += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Identificador")
				@main.tabla1.setItemText(i,1,m[2])
				i+=1
			elsif (m[3] != nil)
				cadena += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Cadena")
				@main.tabla1.setItemText(i,1,m[3])
				i+=1
			elsif (m[4] != nil)
				numeros += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Numero")
				@main.tabla1.setItemText(i,1,m[4])
				i+=1
			elsif (m[5] != nil)
				caracteres += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Caracter")
				@main.tabla1.setItemText(i,1,m[5])
				i+=1
			elsif (m[6] != nil)
				parentesis += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Parentesis")
				@main.tabla1.setItemText(i,1,m[6])
				i+=1
			elsif (m[7] != nil)
				llaves += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Llave")
				@main.tabla1.setItemText(i,1,m[7])
				i+=1
			elsif (m[8] != nil)
				corchetes += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Corchete")
				@main.tabla1.setItemText(i,1,m[8])
				i+=1
			elsif (m[9] != nil)
				puntocoma += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Punto y coma")
				@main.tabla1.setItemText(i,1,m[9])
				i+=1
			elsif (m[10] != nil)
				metodos += 1
				@main.tabla1.appendRows()
				@main.tabla1.setItemText(i,0,"Metodos")
				@main.tabla1.setItemText(i,1,m[10])
				i+=1
			end
		end 

		# Agregan el resultado de los contadores en la segunda tabla
		@main.tabla2.setItemText(0,1,"#{reservada}")
		@main.tabla2.setItemText(1,1,"#{operador}")
		@main.tabla2.setItemText(2,1,"#{identificador}")
		@main.tabla2.setItemText(3,1,"#{cadena}")
		@main.tabla2.setItemText(4,1,"#{numeros}")
		@main.tabla2.setItemText(5,1,"#{caracteres}")
		@main.tabla2.setItemText(6,1,"#{parentesis}")
		@main.tabla2.setItemText(7,1,"#{llaves}")
		@main.tabla2.setItemText(8,1,"#{corchetes}")
		@main.tabla2.setItemText(9,1,"#{puntocoma}")
		@main.tabla2.setItemText(10,1,"#{metodos}")

end

app.create
app.run

