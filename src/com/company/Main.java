package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        // Ejercicio 2
        System.out.println("Ejercicio 2\n");
        URL web = new URL("https://blog.elpuig.xeill.net/?feed=rss2");
        System.out.println("Autoritat:\t"+web.getAuthority());
        System.out.println("Port per defecte:\t"+web.getDefaultPort());
        System.out.println("Recurs:\t"+web.getFile());
        System.out.println("Host:\t"+web.getHost());
        System.out.println("Camí:\t"+web.getPath());
        System.out.println("Protocol:\t"+web.getProtocol());

        byte[] ipAddr = new byte[] { 127, 0, 0, 1 };

        InetAddress[] addresses = new InetAddress[4];

        addresses[0] = InetAddress.getLoopbackAddress();
        addresses[1] = InetAddress.getLocalHost();
        addresses[2] = InetAddress.getByName("ioc.xtec.cat");
        addresses[3] = InetAddress.getByAddress("localhost",ipAddr);

        System.out.println(Arrays.toString(InetAddress.getAllByName("google.com"))) ;
        for(InetAddress adress: addresses){
            System.out.println(adress);
        }

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
