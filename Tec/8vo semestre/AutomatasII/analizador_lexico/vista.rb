require 'fox16'
include Fox

class Vista < FXMainWindow
    
    attr_accessor :btnCargar,:btnAnalizar, :txtArchivo,:tbLexemas,:tbConteo,:fdAbrir

    def initialize(app)
        super(app,"Analizador léxico",:width=>880,:height=>720)
        
        @fdAbrir = FXFileDialog.new(self,"Abrir archivo java")
        @txtArchivo = FXText.new(self, :opts => LAYOUT_EXPLICIT,:x=>10,:y=>15,:width=>350,:height=>400)
        @btnCargar = FXButton.new(self,"Cargar archivo",:opts => LAYOUT_EXPLICIT,:x=>380,:y=>15,:width=>100,:height=>30)
        @btnAnalizar = FXButton.new(self,"Analizar",:opts => LAYOUT_EXPLICIT,:x=>380,:y=>65,:width=>100,:height=>30)
        @tbLexemas = FXTable.new(self,:opts => LAYOUT_EXPLICIT,:x=>490,:y=>15,:width=>380,:height=>400)
        @tbConteo = FXTable.new(self, :opts => LAYOUT_EXPLICIT,:x=>190,:y=>430,:width=>500,:height=>280)
        
        # Tabla de lexemas
        @tbLexemas.setTableSize(0,2)
        @tbLexemas.setColumnWidth(0,190)
        @tbLexemas.setColumnWidth(1,190)
        @tbLexemas.setColumnText(0,"Token")
        @tbLexemas.setColumnText(1,"Lexema")
        @tbLexemas.rowHeaderMode = LAYOUT_FIX_WIDTH
        @tbLexemas.rowHeaderWidth = 0
        
        # Tabla del conteo de tokens encontrados
        @tbConteo.setTableSize(14,2)
        @tbConteo.setColumnWidth(0,275)
        @tbConteo.setColumnWidth(1,275)
        @tbConteo.rowHeaderMode = LAYOUT_FIX_WIDTH
        @tbConteo.rowHeaderWidth = 0
        @tbConteo.setColumnText(0,"Token")
        @tbConteo.setColumnText(1,"Cantidad")

        @tbConteo.setItemText(0,0,"Palabras reservadas")
        @tbConteo.setItemText(1,0,"Identificador")
        @tbConteo.setItemText(2,0,"Metodos")
        @tbConteo.setItemText(3,0,"Operadores aritmético")
        @tbConteo.setItemText(4,0,"Operadores de comparación")
        @tbConteo.setItemText(5,0,"Operadores lógicos")
        @tbConteo.setItemText(6,0,"Constantes numéricas")
        @tbConteo.setItemText(7,0,"Constantes cadena")
        @tbConteo.setItemText(8,0,"Constantes caracter")
        @tbConteo.setItemText(9,0,"Llave")
        @tbConteo.setItemText(10,0,"Paréntesis")
        @tbConteo.setItemText(11,0,"Punto y coma")
        @tbConteo.setItemText(12,0,"Corchetes")
        @tbConteo.setItemText(13,0,"Asignación")

        14.times do |i|
            @tbConteo.setItemJustify(i,0,FXTableItem::LEFT)
            @tbConteo.setItemJustify(i,1,FXTableItem::CENTER_X)
        end

        # Dialogo para abrir un archivo
        @fdAbrir.selectMode = SELECTFILE_EXISTING
        @fdAbrir.patternList = [
            "(*.java)"
        ]  

    end

    def create
        super
        show(PLACEMENT_SCREEN)
    end
end