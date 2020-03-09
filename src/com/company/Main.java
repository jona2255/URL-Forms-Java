package com.company;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        // Ejercicio 2
        System.out.println("Ejercicio 2\n");
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

        URL url = new URL("google.com");
        System.out.println(url);
    }
}
