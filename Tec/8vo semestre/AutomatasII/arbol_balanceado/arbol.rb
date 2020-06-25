require './nodo_arbol'

class Arbol

    def initialize
        @arbol = nil
    end

    def agregar_nodo dato,nombre
        nuevo = NodoArbol.new(dato,nombre)

        if @raiz == nil
            @raiz = nuevo
            puts "Raiz --> [#{@raiz.dato}]"
        else
            auxiliar = @raiz
            padre = nil

            while true
                padre = auxiliar
                
                if dato < auxiliar.dato
                    auxiliar = auxiliar.hijo_izquierdo
                    if auxiliar == nil
                        padre.hijo_izquierdo = nuevo
                        puts "[#{padre.dato} --- izquierda --> [#{padre.hijo_izquierdo.dato}]"
                        return
                    end
                else
                    auxiliar = auxiliar.hijo_derecho
                    if auxiliar == nil
                        padre.hijo_derecho = nuevo
                        puts "[#{padre.dato} --- derecha --> [#{padre.hijo_derecho.dato}]"
                        return
                    end
                end
            end
        end
    end
end