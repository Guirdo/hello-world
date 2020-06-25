require './nodo_arbol'

class Arbol

    def initialize
        @arbol = nil
    end

    def agregar_nodo dato
        nuevo = NodoArbol.new(dato)

        if @raiz == nil
            @raiz = nuevo
            return "Raiz --> [#{@raiz.dato}]"
        else
            auxiliar = @raiz
            padre = nil

            while true
                padre = auxiliar
                
                if dato < auxiliar.dato
                    auxiliar = auxiliar.hijo_izquierdo
                    if auxiliar == nil
                        padre.hijo_izquierdo = nuevo
                        return "[#{padre.dato} --- izquierda --> [#{padre.hijo_izquierdo.dato}]"
                    end
                else
                    auxiliar = auxiliar.hijo_derecho
                    if auxiliar == nil
                        padre.hijo_derecho = nuevo
                        return "[#{padre.dato} --- derecha --> [#{padre.hijo_derecho.dato}]"
                    end
                end
            end
        end
    end

    def pre_orden nodo=@raiz
        if nodo != nil
            salida = nodo.dato.to_s+" "
            salida += pre_orden nodo.hijo_izquierdo
            salida += pre_orden nodo.hijo_derecho
            return salida
        else
            return ""
        end
    end

    def in_orden nodo=@raiz
        if nodo != nil
            salida = ""
            salida += in_orden nodo.hijo_izquierdo
            salida += nodo.dato.to_s+" "
            salida += in_orden nodo.hijo_derecho
            return salida
        else
            return ""
        end
    end

    def post_orden nodo=@raiz
        if nodo != nil
            salida = ""
            salida += post_orden nodo.hijo_izquierdo
            salida += post_orden nodo.hijo_derecho
            salida += nodo.dato.to_s+" "
            return salida
        else
            return ""
        end
    end
end