package com.company.Ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        // Ejercicio 3
        System.out.println("\nEjercicio 3\n");

        String tag;

        //capturar els paràmetres
        URL url = new URL("https://elpuig.xeill.net/");
        tag = "img";

        // patró de cerca regexp
        String pattern = "<" + tag + ".*\\/?>";
        Pattern p = Pattern.compile(pattern);

        System.out.println("busquem a " + url.toString() + " l'etiqueta " + tag);
        //Iniciem la connexió
        HttpURLConnection con = (HttpURLConnection) url.openConnection();


        BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()) );
        String res;
        while( (res = in.readLine()) != null) {
            Matcher m = p.matcher(res);
            //buscar el tag dins de la línia i mostrar la línia
            if(m.find()) System.out.println(res);
        }
        in.close();

    }
}
