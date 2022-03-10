package com.ht06;
import java.util.Map;
import java.util.Scanner;
/**
 * Ultima modificacion: 9/03/2022
 * 
 * Clase main que interactua con el usuario
 * @file Main.java
 * @author Montserrat Gil
 * @author Guillermo Santos
 */


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        boolean opC = false;

        //crear coleccion de cartas
        HashMapFactory<String,String> hashF = new HashMapFactory<String,String>();
        Map<String,String> coleccion;
        Map<String, String> cartas;

        //seleccionar implementacion
        while (!opC){
            System.out.println("\nIngrese la implementacion de map que desee (HM, LM, TM)");
            String implementacion = scan.nextLine();
            try{
                coleccion = hashF.getMap(implementacion);
                cartas = FileManager.leerArchivo(implementacion,"");
                opC = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //seleccionar opcion a hacer
        String salir ="";
        while (!salir.equalsIgnoreCase("7")){
            System.out.println("\nIngrese el numero de la opcion a realizar:\n1. Agregar carta a su coleccion\n2. Mostrar el tipo de una carta\n3. Mostrar su coleccion de cartas\n4. Mostrar su coleccion de cartas ordenadas por tipo\n5. Mostrar todas las cartas existentes\n6. Mostrar todas las cartas existentes ordenadas por tipo\n7. Salir\n");
            salir = scan.nextLine();
            if (salir.equals("1")){
                //agregar carta a coleccion

            } else if (salir.equals("2")){
                //mostrar tipo de una carta especifica

            } else if (salir.equals("3")){
                //mostrar cartas en coleccion

            } else if (salir.equals("4")){
                //mostrar cartas en coleccion ordenadas por tipo

            } else if (salir.equals("5")){
                //mostrar todas las cartas existentes

            } else if (salir.equals("6")){
                //mostrar todas las cartas existentes por tipo

            } else if (salir.equals("7")){
                //salir
                System.out.println("Saliendo del programa");
            } else {
                System.out.println("\nOpcion invalida");
            }
        }
        scan.close();
    }
}
