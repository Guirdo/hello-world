require 'fox16'
include Fox

class Ventana < FXMainWindow

    #attr_accessor :tfNombre,:tfApePaterno,:tfApeMaterno,:cbSexo,:cbDiaNacimiento,:cbMesNacimiento,:cbAnioNacimiento,:tfClaveEstado

    def initialize(app)
        super(app,"Generacion de CURP",:width=>400,:height=>400)
        FXLabel.new(self,"Nombre(s): ",:opts=>LAYOUT_EXPLICIT,:width=>120,:height=>20,:x=>15,:y=>20)
        @tfNombre = FXTextField.new(self,50,:opts=>LAYOUT_EXPLICIT,:width=>150,:height=>20,:x=>150,:y=>20)

        FXLabel.new(self,"Apellido paterno: ",:opts=>LAYOUT_EXPLICIT,:width=>120,:height=>20,:x=>15,:y=>60)
        @tfApePaterno = FXTextField.new(self,50,:opts=>LAYOUT_EXPLICIT,:width=>150,:height=>20,:x=>150,:y=>60)

        FXLabel.new(self,"Apellido materno: ",:opts=>LAYOUT_EXPLICIT,:width=>120,:height=>20,:x=>15,:y=>100)
        @tfApeMaterno = FXTextField.new(self,50,:opts=>LAYOUT_EXPLICIT,:width=>150,:height=>20,:x=>150,:y=>100)

        FXLabel.new(self,"Sexo: ",:opts=>LAYOUT_EXPLICIT,:width=>120,:height=>20,:x=>15,:y=>140)
        @cbSexo = FXComboBox.new(self,2,:opts=>LAYOUT_EXPLICIT,:width=>150,:height=>20,:x=>150,:y=>140)
        @cbSexo.appendItem("Mujer")
        @cbSexo.appendItem("Hombre")

        FXLabel.new(self,"Fecha de nacimiento: ",:opts=>LAYOUT_EXPLICIT,:width=>120,:height=>20,:x=>15,:y=>180)
        @cbDiaNacimiento = FXComboBox.new(self,31,:opts=>LAYOUT_EXPLICIT,:width=>40,:height=>20,:x=>150,:y=>180)
        @cbDiaNacimiento.numVisible = 15
        31.times do |i|
            if i+1 < 10
                @cbDiaNacimiento.appendItem("0#{i+1}")
            else
                @cbDiaNacimiento.appendItem("#{i+1}")
            end
        end

        FXLabel.new(self,"/",:opts=>LAYOUT_EXPLICIT,:width=>20,:height=>20,:x=>200,:y=>180)
        @cbMesNacimiento = FXComboBox.new(self,30,:opts=>LAYOUT_EXPLICIT,:width=>40,:height=>20,:x=>230,:y=>180)
        @cbMesNacimiento.numVisible = 10
        12.times do |i|
            if i+1 < 10 
                @cbMesNacimiento.appendItem("0#{i+1}")
            else
                @cbMesNacimiento.appendItem("#{i+1}")
            end
        end

        FXLabel.new(self,"/",:opts=>LAYOUT_EXPLICIT,:width=>20,:height=>20,:x=>280,:y=>180)
        @cbAnioNacimiento = FXComboBox.new(self,30,:opts=>LAYOUT_EXPLICIT,:width=>60,:height=>20,:x=>310,:y=>180)
        @cbAnioNacimiento.numVisible = 10
        41.times do |i|
            @cbAnioNacimiento.appendItem("#{i+1980}")
        end

       FXLabel.new(self,"Clave estado: ",:opts=>LAYOUT_EXPLICIT,:width=>120,:height=>20,:x=>15,:y=>220)
       @tfClaveEstado = FXTextField.new(self,50,:opts=>LAYOUT_EXPLICIT,:width=>150,:height=>20,:x=>150,:y=>220)

       @btnGenerar = FXButton.new(self,"Generar",:opts=>LAYOUT_EXPLICIT,:width=>100,:height=>25,:x=>150,:y=>260)
       @btnGenerar.connect(SEL_COMMAND) do
           generar_curp
       end
       
       FXLabel.new(self,"CURP generada: ",:opts=>LAYOUT_EXPLICIT,:width=>120,:height=>20,:x=>15,:y=>310)
       @lblCURP = FXLabel.new(self,"",:opts=>LAYOUT_EXPLICIT,:width=>200,:height=>20,:x=>150,:y=>310)

       @lblValidacion = FXLabel.new(self,"",:opts=>LAYOUT_EXPLICIT,:width=>200,:height=>20,:x=>150,:y=>350)
    end

    def create
        super
        show(PLACEMENT_SCREEN)
    end

    def generar_curp
        nombre = @tfNombre.text.upcase!
        apellido_paterno = @tfApePaterno.text.upcase!
        apellido_materno = @tfApeMaterno.text.upcase!
        sexo = if @cbSexo.currentItem == 0
                    "M"
        else
            "H"
        end

        dia_nacimiento = @cbDiaNacimiento.getItemText(@cbDiaNacimiento.currentItem)
        mes_nacimiento = @cbMesNacimiento.getItemText(@cbMesNacimiento.currentItem)
        anio_nacimiento = @cbAnioNacimiento.getItemText(@cbAnioNacimiento.currentItem)
        clave_estado = @tfClaveEstado.text.upcase!

        curp_generada = ""
        curp_generada += apellido_paterno[ apellido_paterno =~ /[B-DF-HJ-NP-TV-Z]/]
        curp_generada += apellido_paterno[ apellido_paterno =~ /[AEIOU]/ ]
        curp_generada += apellido_materno[ apellido_paterno =~/[B-DF-HJ-NP-TV-Z]/ ]
        curp_generada += nombre[ nombre =~ /[A-Z]/ ]
        curp_generada += anio_nacimiento.match(/(?<=19|20)[0-9]{2}/).to_s
        curp_generada += "#{mes_nacimiento}#{dia_nacimiento}#{sexo}#{clave_estado}"
        m =  /(?<=[AEIOU])[B-DF-HJ-NP-TV-Z]/.match(apellido_paterno)
        curp_generada += apellido_paterno[ m.end(0)-1 ]
        m =  /(?<=[AEIOU])[B-DF-HJ-NP-TV-Z]/.match(apellido_materno)
        curp_generada += apellido_materno[ m.end(0)-1 ]
        m =  /(?<=[AEIOU])[B-DF-HJ-NP-TV-Z]/.match(nombre)
        curp_generada += nombre[ m.end(0)-1 ]

        caracteres_alfanumericos = %w{0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z}
        numero = caracteres_alfanumericos.length

        curp_generada += caracteres_alfanumericos[rand(numero)] + rand(10).to_s

        @lblCURP.text = curp_generada

        regex_curp = /[A-Z][AEIOU][A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[0-9]|[1-2][0-9]|3[0-1])[MH][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z][0-9]/
        m1 = regex_curp.match curp_generada

        @lblValidacion.text = if m1.class == MatchData
                                    "VALIDA"
                                else
                                    "INVALIDA"
                                end    

    end
end

app = FXApp.new
main = Ventana.new(app)
app.create
app.run