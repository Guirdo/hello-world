require './vista.rb'
require './controlador.rb'


app = FXApp.new
ventana = Vista.new(app)

controlador = Controlador.new(ventana)

app.create
app.run