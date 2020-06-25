# -*- coding: utf-8 -*-

import re
from operator import itemgetter
from PyPDF2 import PdfFileReader
from reportlab.pdfgen import canvas
from matplotlib import pyplot

def analizar_pdf(archivo):
    # Se inicializan variables importantes
    frecuencia = {}
    pdf = PdfFileReader(open(archivo,'rb'))
    paginas = pdf.getNumPages()

    # El ciclo va extrallendo el contenido de cada pagina del archivo
    for page in range(1,paginas):
        pagina = pdf.getPage(page)
        texto = pagina.extractText()
        # Expresion regular para sacar las palabras del archivo.
        palabras = re.findall('[A-Za-záéíóúÁÉÍÍÚ][a-záéíóúÁÉÍÍÚ]*',texto)
    
        # Por cada pagina, va checando la frecuencia de las palabras
        # y las va agregando a un diccionario.
        for palabra in palabras:
            cuenta = frecuencia.get(palabra,0)
            frecuencia[palabra] = cuenta + 1

    # Aplico la ley de Zifp. y ordeno el diccionario de las palabras encontradas
    frecuencia = sorted(frecuencia.items(), key = itemgetter(1))
    
    #Creo reporte de analisis
    crear_reporte(frecuencia,archivo)
    
def crear_reporte(frecuencia,archivo):
    nombre_archivo = "reporte_de_"+archivo.replace(".pdf","")
    pdf = canvas.Canvas(nombre_archivo+".pdf")
    pdf.setTitle(nombre_archivo)
    
    pdf.setFont("Times-Roman", 20)
    pdf.drawString(100, 800, "Reporte del archivo "+archivo.replace(".pdf",""))
    
    pdf.setFont("Times-Roman",18)
    pdf.drawString(50,750,"Numero de palabras: "+str(frecuencia.__len__()))
    pdf.drawString(50,725,"Palabra más utilizada: "+frecuencia[-1][0])
    pdf.drawString(50,700,"Palabra menos utilizada: "+frecuencia[0][0])
    
    generar_grafica(frecuencia,nombre_archivo)
    pdf.drawInlineImage(nombre_archivo+".png", 50, 400)
    
    pdf.save()
    
def generar_grafica(frecuencia,nombre):
    frecuencia = list(map(itemgetter(1),frecuencia))
    frecuencia.reverse()
    pyplot.plot(frecuencia)
    pyplot.savefig(nombre+".png")


if __name__ == "__main__":
    # Se solicita al usuario introduzca la direccion del archivo
    print("Introduzca la direccion del archivo #1: ")
    archivo = input()
    print("Introduzca la direccion del archivo #2: ")
    archivo1 = input()
    
    analizar_pdf(archivo)
    analizar_pdf(archivo1)

