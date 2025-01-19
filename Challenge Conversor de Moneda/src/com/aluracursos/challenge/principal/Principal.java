package com.aluracursos.challenge.principal;

import com.aluracursos.challenge.modelos.ConsultaTasaDeCambio;
import com.aluracursos.challenge.modelos.TasasDeCambio;

import java.util.Scanner;

public class Principal {

    static Scanner lectura = new Scanner(System.in);
    static ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();

    public static void main(String[] args) {
        double valorMonedaBase;
        int opcion = -1;
        while (opcion != 0) {
            opcion = selecionarOpcionMenu();
            switch (opcion) {
                case 0:
                    System.out.println("Finalizando programa ...");
                    break;
                case 1:
                    valorMonedaBase = ingresarMonedaBase("dólares");
                    convertirMoneda("USD", valorMonedaBase, "ARS");
                    break;
                case 2:
                    valorMonedaBase = ingresarMonedaBase("pesos argentinos");
                    convertirMoneda("ARS", valorMonedaBase, "USD");
                    break;
                case 3:
                    valorMonedaBase = ingresarMonedaBase("dólares");
                    convertirMoneda("USD", valorMonedaBase, "BRL");
                    break;
                case 4:
                    valorMonedaBase = ingresarMonedaBase("reales brasileños");
                    convertirMoneda("BRL", valorMonedaBase, "USD");
                    break;
                case 5:
                    valorMonedaBase = ingresarMonedaBase("dólares");
                    convertirMoneda("USD", valorMonedaBase, "COP");
                    break;
                case 6:
                    valorMonedaBase = ingresarMonedaBase("pesos colombianos");
                    convertirMoneda("COP", valorMonedaBase, "USD");
                    break;
            }
        }
    }

    private static double ingresarMonedaBase(String moneda) {
        double valorMonedaBase = 0.0;
        boolean salida = false;
        while (!salida) {
            try {
                System.out.print("Ingrese el valor en " + moneda +": ");
                valorMonedaBase = Double.parseDouble(lectura.nextLine());
                salida = true;
            } catch (Exception e) {
                System.out.println("Formato inválido. Intente nuevamente");
            }
        }
        return valorMonedaBase;
    }

    private static int selecionarOpcionMenu() {
        int opcion;
        System.out.println("******************************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Monedas =)\n");
        System.out.println("\t1. Dólar ---> Peso argentino");
        System.out.println("\t2. Peso argentino ---> Dolár");
        System.out.println("\t3. Dólar ---> Real brasileño");
        System.out.println("\t4. Real brasileño ---> Dólar");
        System.out.println("\t5. Dólar ---> Peso Colombiano");
        System.out.println("\t6. Peso colombiano ---> Dólar");
        System.out.println("\t0. Salir\n");
        System.out.println("******************************************************************");
        System.out.print("Elige una opción válida: ");
        try {
            opcion = Integer.parseInt(lectura.nextLine());
        } catch (Exception e){
            System.out.println("Formato invalido. Intente nuevamente");
            opcion = -2;
        }
        return opcion;

    }

    public static void convertirMoneda(String monedaBase, double valorMonedaBase,
                                       String codigoMonedaFinal){
        try{
            TasasDeCambio tasasDeCambio = consulta.buscaTasasDeCambio(monedaBase);
            System.out.println(tasasDeCambio.convertirMoneda(valorMonedaBase, codigoMonedaFinal));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}