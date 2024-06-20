package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ConectionAPI consulta = new ConectionAPI();

        while (true) {
            System.out.println("""
                
                          *** Bienvenido/a al Covertidor de Monedas ***
                    ¿Qué le gustaría hacer a continuación?
                    1. Hacer una conversión
                    2. Salir""");

            int opcion = consola.nextInt();
            consola.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("""

                            ******* Covertidor de Monedas de Alura - ONE ******

                                Ingrese el codigo de la moneda de origen:
                            Peso mexicano - MXN             Dólar estadounidense - USD
                            Euro - EUR                      Peso argentino - ARS
                            Real brasileño - BRL            Peso chileno - CLP
                            Peso colombiano - COP           Sol peruano - PEN
                            Bolívar venezolano - VES        Euro - EUR
                            
                            
                            """);
                    String monedaOrigen = consola.nextLine().toUpperCase();

                    System.out.println("""
                                Ingrese el código de la moneda de destino:
                            Peso mexicano - MXN             Dólar estadounidense - USD
                            Euro - EUR                      Peso argentino - ARS
                            Real brasileño - BRL            Peso chileno - CLP
                            Peso colombiano - COP           Sol peruano - PEN
                            Bolívar venezolano - VES        Euro - EUR
                            """);
                    String monedaDestino = consola.nextLine().toUpperCase();

                    String resultado = Conversion.Convertir(monedaOrigen, monedaDestino, consulta, consola);
                    LocalDateTime time = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    String reg = String.format("Conversion: %s - Fecha y Hora: %s", resultado, time.format(formatter));
                    break;

                case 2:
                    System.out.println("Gracias por su visita.");
                    return;

                default:
                    System.out.println("Seleccione una opción válida.");
                    break;
            }
        }

    }
}