class NodoArbol

    attr_accessor :dato, :hijo_izquierdo,:hijo_derecho

    def initialize dato
        @dato = dato
    end

    def imprimir
        "Su dato es #{@dato}"
    end
end