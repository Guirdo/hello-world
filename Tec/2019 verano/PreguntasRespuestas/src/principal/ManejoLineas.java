package principal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManejoLineas {

    public static boolean esPreguntas(String linea) {
        return linea.matches("[Pp]\\s[\\w\\W]*");
    }

    public static boolean esRespuesta(String linea) {
        return linea.matches("[#]\\s?[\\w\\W]*");
    }

    public static boolean esRespuestaCorrecta(String linea) {
        return linea.matches("(->)\\s?[\\w\\W]*");
    }

    public static String darRespuesta(String linea) {
        return darCadena(linea, "[#]\\s?(?<res>[\\w\\W]*)", "res");
    }

    public static String darRespuestaCorrecta(String linea) {
        return darCadena(linea, "(->)\\s?(?<res>[\\w\\W]*)", "res");
    }

    public static String darPregunta(String linea) {
        return darCadena(linea, "[Pp]\\s(?<pre>[\\w\\W]*)", "pre");
    }

    private static String darCadena(String linea, String regex, String nombreGrupo) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        String resultado = "";

        while (matcher.find()) {
            resultado = matcher.group(nombreGrupo);
        }

        return resultado;
    }
}
