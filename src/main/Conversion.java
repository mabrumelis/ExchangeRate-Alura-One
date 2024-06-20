package main;

import java.util.Scanner;

import models.Moneda;

public class Conversion {
   public static String Convertir(String monedaBaseTxt, String monedaCambioTxt, ConnectionAPI consulta, Scanner consola){
    double monto;
    double montoFinal;

    Moneda monedas = consulta.SearchCoins(monedaBaseTxt, monedaCambioTxt);
    System.out.println("La tasa de conversion de esta moneda es de:\n1 " + monedaBaseTxt + " = " + monedas.conversion_rate() + " " + monedaCambioTxt);
    System.out.println("Cantidad de: " + monedaBaseTxt);
    monto = Double.parseDouble(consola.nextLine());
    montoFinal = monto * monedas.conversion_rate();
    String resultado = monto + " " + monedaBaseTxt + " equivale a " + montoFinal + " " + monedaCambioTxt;
    System.out.println("\n" + resultado);
    return resultado;
   }
}
