package org.example;

import org.springframework.beans.factory.annotation.Value;

public class Main {
    @Value("jasper.url")
    private static String jasperUrl;

    @Value("jasper.path")
    private static String jasperPath;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("JasperUrl: " + jasperUrl);
        System.out.println("JasperPath: " + jasperPath);
    }

}