package com.company.Ex4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        // Ejercicio 4
        System.out.println("\nEjercicio 4\n");

        String nombre = "Jonatan";
        String bool ="Si";

        URL url = new URL("https://docs.google.com/forms/u/0/d/e/1FAIpQLScE6sxLFb3BmCmT2TKHQH5ormS0qvjHwO-uTAR8MXaagBvSSQ/formResponse");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        DataOutputStream out = new DataOutputStream (connection.getOutputStream());
        out.writeBytes("entry.835030737="+nombre+"&entry.1616686619="+bool);
        out.flush();
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        while((line=in.readLine())!=null) {
            System.out.println(line);
        }
        in.close();
    }

}

