require 'fox16'
include Fox

class Ventana < FXMainWindow
    
    attr_accessor :btnAgregar, :tfValor, :txtArbol, :txtPreOrden, :txtInOrden, :txtPostOrden

    def initialize(app)
        super(app,"Arbol binario",:width=>410,:height=>480)
        hframe1 = FXHorizontalFrame.new(self,)
        FXLabel.new(hframe1,"Valor entero: ")
        @tfValor = FXTextField.new(hframe1,15)
        @btnAgregar = FXButton.new(hframe1,"Agregar")

        hframe2 = FXHorizontalFrame.new(self)
        FXLabel.new(hframe2,"Arbol balanceado: ")
        @txtArbol = FXText.new(hframe2)
        @txtArbol.visibleColumns=40
        @txtArbol.visibleRows=6

        hframe3 = FXHorizontalFrame.new(self)
        FXLabel.new(hframe3,"              Pre-orden: ")
        @txtPreOrden = FXText.new(hframe3)
        @txtPreOrden.visibleColumns=40
        @txtPreOrden.visibleRows=6

        hframe4 = FXHorizontalFrame.new(self)
        FXLabel.new(hframe4,"                In-orden: ")
        @txtInOrden = FXText.new(hframe4)
        @txtInOrden.visibleColumns=40
        @txtInOrden.visibleRows=6

        hframe5 = FXHorizontalFrame.new(self)
        FXLabel.new(hframe5,"             Post-orden: ")
        @txtPostOrden = FXText.new(hframe5)
        @txtPostOrden.visibleColumns=40
        @txtPostOrden.visibleRows=6

    end

    def create
        super
        show(PLACEMENT_SCREEN)
    end
end

