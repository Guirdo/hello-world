class Controlador

    def initialize (vista)
        @vista = vista
        @codigo = ""
        @patron = %r{
            (abstract|assert|boolean|break|byte|case|class|catch|char|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|null|public|package|private|protetec|return|static|short|strictfp|super|switch|synchronized|this|throw|throws|void|transient|try|void|volatile|while)|                   # 1. Reservadas
            ([A-Za-z][\w]*)|                        # 2. Identificadores
            ([\.][A-Za-z][\w]*)|                    # 3. Metodos
            ([^\.,"\]][+-\/%]|[*])|                          # 4. Aritméticos
            ([><]|<=|>=|==|!=)|                     # 5. Comparación
            ([|]{2}|&&)|                            # 6. Lógicos
            (\d+\.\d+|\d|0x[A-F\d]+)|               # 7. Constantes numericas
            ("[\w\s]*")|                            # 8. Constante cadena
            ('.')|                                  # 9. Constante caracter
            ([\{\}])|                               # 10. Llaves
            ([\(\)])|                               # 11. Parentesis
            (;)|                                    # 12. Punto y coma
            ([\]\[])|                               # 13. Corchetes
            ([=])                                   # 14. Asignación
        }x

        @vista.btnCargar.connect(SEL_COMMAND) do
            if(@vista.txtArchivo.text != "")
                limpiar_tablas_texto
            end

            cargar_archivo
        end

        @vista.btnAnalizar.connect(SEL_COMMAND) do
            if(@vista.txtArchivo.text != "")
                analizar_texto
            end
        end

    end

    def limpiar_tablas_texto
        # Limpia el texto
        @vista.txtArchivo.removeText(0,@vista.txtArchivo.length)

        # Limpia la tabla de lexemas
        @vista.tbLexemas.removeRows(0,@vista.tbLexemas.numRows)

        # Limpia los contadores de la segunda tabla
        13.times do |i|
            @vista.tbConteo.setItemText(i,1,"")
        end
    end

    def cargar_archivo
        if @vista.fdAbrir.execute != 0
            File.foreach(@vista.fdAbrir.filename) do |linea|
                @codigo+=linea
                @vista.txtArchivo.appendText(linea)
            end
        end
    end

    def analizar_texto
        indice = 0
        contadores = [0,0,0,0,0,0,0,0,0,0,0,0,0,0]

        @codigo.scan(@patron).each do |lexema|
            if(lexema[0] != nil)
                insertar_lexema(indice,"Palabra reservada",lexema[0])
                contadores[0]+=1
                indice+=1
            elsif(lexema[1] != nil)
                insertar_lexema(indice,"Identificador",lexema[1])
                contadores[1]+=1
                indice+=1
            elsif(lexema[2] != nil)
                insertar_lexema(indice,"Metodos",lexema[2])
                contadores[2]+=1
                indice+=1
            elsif(lexema[3] != nil)
                insertar_lexema(indice,"Operador aritmético",lexema[3])
                contadores[3]+=1
                indice+=1
            elsif(lexema[4] != nil)
                insertar_lexema(indice,"Operador de comparación",lexema[4])
                contadores[4]+=1
                indice+=1
            elsif(lexema[5] != nil)
                insertar_lexema(indice,"Operador lógico",lexema[5])
                contadores[5]+=1
                indice+=1
            elsif(lexema[6] != nil)
                insertar_lexema(indice,"Constante numérico",lexema[6])
                contadores[6]+=1
                indice+=1
            elsif(lexema[7] != nil)
                insertar_lexema(indice,"Constante cadena",lexema[7])
                contadores[7]+=1
                indice+=1
            elsif(lexema[8] != nil)
                insertar_lexema(indice,"Constate caracter",lexema[8])
                contadores[8]+=1
                indice+=1
            elsif(lexema[9] != nil)
                insertar_lexema(indice,"Llaves",lexema[9])
                contadores[9]+=1
                indice+=1
            elsif(lexema[10] != nil)
                insertar_lexema(indice,"Paréntesis",lexema[10])
                contadores[10]+=1
                indice+=1
            elsif(lexema[11] != nil)
                insertar_lexema(indice,"Punto y coma",lexema[11])
                contadores[11]+=1
                indice+=1
            elsif(lexema[12] != nil)
                insertar_lexema(indice,"Corchetes",lexema[12])
                contadores[12]+=1
                indice+=1
            elsif(lexema[13] != nil)
                insertar_lexema(indice,"Asignación",lexema[13])
                contadores[13]+=1
                indice+=1
            end
        end

        insertar_contadores(contadores)
    end

    def insertar_lexema indice,token,lexema
        @vista.tbLexemas.appendRows()
        @vista.tbLexemas.setItemText(indice,0,token)
        @vista.tbLexemas.setItemText(indice,1,lexema)
        @vista.tbLexemas.setItemJustify(indice,0,FXTableItem::LEFT)
        @vista.tbLexemas.setItemJustify(indice,1,FXTableItem::CENTER_X)
    end

    def insertar_contadores contadores
        @vista.tbConteo.setItemText(0,1,contadores[0].to_s)
        @vista.tbConteo.setItemText(1,1,contadores[1].to_s)
        @vista.tbConteo.setItemText(2,1,contadores[2].to_s)
        @vista.tbConteo.setItemText(3,1,contadores[3].to_s)
        @vista.tbConteo.setItemText(4,1,contadores[4].to_s)
        @vista.tbConteo.setItemText(5,1,contadores[5].to_s)
        @vista.tbConteo.setItemText(6,1,contadores[6].to_s)
        @vista.tbConteo.setItemText(7,1,contadores[7].to_s)
        @vista.tbConteo.setItemText(8,1,contadores[8].to_s)
        @vista.tbConteo.setItemText(9,1,contadores[9].to_s)
        @vista.tbConteo.setItemText(10,1,contadores[10].to_s)
        @vista.tbConteo.setItemText(11,1,contadores[11].to_s)
        @vista.tbConteo.setItemText(12,1,contadores[12].to_s)
        @vista.tbConteo.setItemText(13,1,contadores[13].to_s)
    end

end