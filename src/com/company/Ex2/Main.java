package com.company.Ex2;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MalformedURLException, UnknownHostException {
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


    }
}
