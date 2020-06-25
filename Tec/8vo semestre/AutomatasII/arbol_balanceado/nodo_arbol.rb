class NodoArbol

    attr_accessor :dato,:nombre, :hijo_izquierdo,:hijo_derecho 

    def initialize dato,nombre
        @dato = dato
        @nombre = nombre
        
    end

    def imprimir
        "#{@nombre} su dato es #{@dato}"
    end
end