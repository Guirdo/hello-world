require './arbol'
require './ventana'

def agregar_valor
    @main.txtArbol.text += @arbol.agregar_nodo(@main.tfValor.text.to_i)+"\n"
    @main.tfValor.text = ""

    @main.txtPreOrden.text = @arbol.pre_orden
    @main.txtInOrden.text = @arbol.in_orden
    @main.txtPostOrden.text = @arbol.post_orden
end

def principal
    @arbol = Arbol.new

    app = FXApp.new
    @main = Ventana.new(app)
    @main.btnAgregar.connect(SEL_COMMAND) do
        agregar_valor
    end
    app.create
    app.run
end

principal