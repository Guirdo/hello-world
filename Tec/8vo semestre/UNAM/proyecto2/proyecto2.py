import re
import pyttsx3
import tkinter as tk

# Variables globales
raiz = tk.Tk()
frase_esp = tk.StringVar()
traduccion_f = tk.StringVar()
traduccion_chu = tk.StringVar()
chu_tra = ""
f_tra = ""

def generar_ventana():
    raiz.title("Traductor F y Chu")
    raiz.resizable(False,False)

    miFrame = tk.Frame(raiz,width="450",height="400")

    tk.Label(miFrame,text="Introduzca frase a traducir:").place(x=20,y=20)
    frase = tk.Entry(raiz,textvariable=frase_esp)
    frase.place(x=20,y=45,width=400)
    
    btnTraducir = tk.Button(miFrame,text="Traducir",command=traducir_frase)
    btnTraducir.place(x=350,y=70)
    
    tk.Label(miFrame,text="Lenguaje F").place(x=20,y=90)
    lblFLen =  tk.Label(miFrame,textvariable=traduccion_f)
    lblFLen.place(x=20,y=120)
    
    tk.Label(miFrame,text="Lenguaje Chu").place(x=20,y=160)
    lblChuLen =  tk.Label(miFrame,textvariable=traduccion_chu)
    lblChuLen.place(x=20,y=190)
    
    btnTraducir = tk.Button(miFrame,text="ESCUCHAR",command=sintetizar_voz)
    btnTraducir.place(x=350,y=220)

    miFrame.pack()
    raiz.mainloop()
    
def traducir_frase():
    frase = frase_esp.get()
    chu_tra = re.sub("([b-df-hj-np-tv-z][aeiou])","chu\\1",frase)
    f_tra = re.sub("([b-df-hj-np-tv-z])([aeiou])","\\1\\2f\\2",frase)
    
    traduccion_f.set(f_tra)
    traduccion_chu.set(chu_tra)
    
def sintetizar_voz():
    frase = frase_esp.get()
    engine = pyttsx3.init("espeak")

    engine.setProperty('rate', 100)
    engine.setProperty('volume', 0.9)  

    engine.say(frase)
    engine.say(f_tra)
    engine.say(chu_tra)    

    engine.runAndWait()


if __name__ == "__main__":
    generar_ventana()
