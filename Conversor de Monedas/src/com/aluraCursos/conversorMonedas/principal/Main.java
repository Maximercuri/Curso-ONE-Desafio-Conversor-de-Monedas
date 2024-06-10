package com.aluraCursos.conversorMonedas.principal;

import com.aluraCursos.conversorMonedas.modelos.ConversorDeDivisas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner teclado = new Scanner(System.in);
        var conversor = new ConversorDeDivisas();

        double monto;
        int eleccion;
        String divisaFinal;
        String divisaInicial;

        String menu = """
                      *******************************************************************************************
                                                Sea Bienvenido al conversor de divisas
                      
                      Por favor seleccione una de las siguientes opciones de conversion:
                      
                      1) Dólar (USD) -> Peso Argentino (ARS)
                      2) Peso Argentino (ARS) -> Dólar (USD)
                      3) Dólar (USD) -> Real Brasileño (BRL)
                      4) Real Brasileño (BRL) -> Dólar (USD)
                      5) Dólar (USD) -> Peso Colombiano (COP)
                      6) Peso Colombiano (COP) -> Dólar (USD)
                      7) Cambio Personalizado
                      8) Salir Del Programa
                      
                      *******************************************************************************************
                      """;

        while (true){
            System.out.println(menu);
            eleccion = teclado.nextInt();

            if (eleccion == 8){
                System.out.println("¡Finalizando el programa!");
                break;
            }

            switch (eleccion){
                case 1:
                    System.out.println("Ingrese el monto de dólares a convertir en pesos argentinos: ");
                    monto = teclado.nextDouble();
                    conversor.convertir("USD", "ARS", monto);


                    break;

                case 2:
                    System.out.println("Ingrese el monto de pesos argentinos a convertir en dólares: ");
                    monto = teclado.nextDouble();
                    conversor.convertir("ARS", "USD", monto);
                    break;

                case 3:
                    System.out.println("Ingrese el monto de dólares a convertir en reales brasileños: ");
                    monto = teclado.nextDouble();
                    conversor.convertir("USD", "BRL", monto);
                    break;

                case 4:
                    System.out.println("Ingrese el monto de reales brasileños a convertir en dólares: ");
                    monto = teclado.nextDouble();
                    conversor.convertir("BRL", "USD", monto);
                    break;

                case 5:
                    System.out.println("Ingrese el monto de dólares a convertir en pesos colombianos: ");
                    monto = teclado.nextDouble();
                    conversor.convertir("USD", "COL", monto);
                    break;

                case 6:
                    System.out.println("Ingrese el monto de pesos colombianos a convertir en dólares: ");
                    monto = teclado.nextDouble();
                    conversor.convertir("COL", "USD", monto);
                    break;

                case 7:
                    try{
                    teclado.nextLine();
                    System.out.println("Ingrese el código de la divisa a la cual convertir: ");
                    divisaFinal = teclado.nextLine();
                    System.out.println("Ahora ingrese el código de la divisa que busca convertir: ");
                    divisaInicial = teclado.nextLine();
                    System.out.println("Por ultimo, ingrese el monto a convertir: ");
                    monto = teclado.nextDouble();
                    conversor.convertir(divisaInicial, divisaFinal, monto);
                    break;
                    } catch (Exception e) {
                        System.out.println("Error en los inputs, intenta de nuevo");
                        System.out.println(e.getMessage());
                    }

                default:
                    System.out.println("El numero ingresado no corresponde a una opción valida, por favor ingresa otro numero");
            }

            System.out.println("Gracias por utilizar este conversor de divisas. ¡Adios!");
        }

    }
}