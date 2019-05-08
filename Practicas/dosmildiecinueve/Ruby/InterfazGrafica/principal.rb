require 'FXRuby'
include fox

class Ventana
    def initialize(app)
        super(app,"Automata - RFC",:width=>200,:height=>200)
    end

    def create
        super
        show(PLACEMENT_SCREEN)
    end
end

app = FXApp.new
