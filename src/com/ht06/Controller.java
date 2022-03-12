package com.ht06;
import java.util.*;

/**
 * Ultima modificacion: 9/03/2022
 * 
 * Clase en la que se desarrolla la logica del programa?
 * @file Controller.java
 * @author Montserrat Gil
 * @author Guillermo Santos
 */
public class Controller {

    /**
     * Obtiene el tipo de una carta
     * @param key nombre de la carta
     * @param map mapa con todas las cartas existentes
     * @return
     * @throws Exception
     */
    public static String obtenerTipo(String key,Map<String,String> map) throws Exception{
        String carta =map.get(key);
        if (carta==null){
            throw new Exception("Error carta no esta en las existentes");
        }
        return carta;
    }

    /**
     * Agrega carta a coleccion
     * @param key nombre de la carta
     * @param map mapa con todas las cartas existentes
     * @param coleccion coleccion a agregar
     * @throws Exception
     * @return
     */
    public static Map<String,String> agregarCarta(String key,Map<String,String> map,Map<String,String> coleccion) throws Exception{
        coleccion.put(key,obtenerTipo(key,map));
        return coleccion;
    }

    /**
     * Regresa un string listo para imprimir con todas las cartas del mapa
     * @param mapa del que se quiere saber los objetos
     * @return
     */
    public static String printMapa(Map<String,String> mapa,boolean imprimirMapa){
        String s="";
        if (mapa.isEmpty()){
            s="\nCollecion vacia";
        } else {
            if (imprimirMapa){
                s="\nCartas en la coleccion";
                for (String carta: mapa.keySet()){
                    s = s + "\n Nombre: "+carta +", Tipo: "+mapa.get(carta);
                }
            } else {
                //s="\nTiempo de corrida promedio: ";
                long tiempo=0;
                for (int i=0;i<20;i++){
                    long t1 = System.nanoTime();
                    for (String carta: mapa.keySet()){
                        mapa.get(carta);
                    }
                    tiempo+=System.nanoTime()-t1;
                }
                s=tiempo/20+" ";
            }
        }

        return s;
    }

    /**
     * Regresa un string listo para imprimir con todas las cartas del mapa
     * Ordenadas por tipo
     * @param mapa del que se quiere saber los objetos
     * @return
     */
    public static String printMapaOrdenado(Map<String,String> mapa,boolean imprimirMapa){
        String s = "";  // String to be returned

        // Logic to compare two entries
        Comparator<Map.Entry> compareByKeyType = new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                Comparable value1 = (Comparable) o1.getValue();
                Comparable value2 = (Comparable) o2.getValue();
                return value1.compareTo(value2);
            }
        };
        Set entrySet = mapa.entrySet(); // Get the entry set for this map
        ArrayList<Map.Entry> sortedEntries = new ArrayList(entrySet);   // Convert the entry set to an array
        sortedEntries.sort(compareByKeyType);   // Sort the entries
        if (mapa.isEmpty()){
            s="\nCollecion vacia";
        } else {
            if(imprimirMapa){
                s="\nCartas en la coleccion";
                for (Map.Entry entry:
                        sortedEntries) {
                    s = s + "\n Nombre: "+entry.getKey() +", Tipo: "+ entry.getValue();
                }
            } else {
                s="\nTiempo de corrida promedio: ";
                long tiempo=0;
                for (int i=0;i<20;i++){
                    long t1 = System.nanoTime();
                    for (Map.Entry entry:
                            sortedEntries) {
                        entry.getKey();
                        entry.getValue();
                    }
                    tiempo+=System.nanoTime()-t1;
                }
                s+=tiempo/20+" nanosegundos";
            }

        }
        // Iterate and append to the entry



        return s;
    }

    /**
     * Regresa un string listo para imprimir con el tiempo que toda obtener cierta cantidad de valores
     * Metodo para luego analizar la complejidad de tiempo del HashMap
     * @return
     */
    public static String cantTiempo(){
        String s = "\nCant. \tTiempo";
        //estabilizar el tiempo
        for (int i = 1; i<11;i++){
            try{
                Map<String, String> valores = FileManager.leerArchivoCant("HM","cards_desc.txt",10);
                Controller.printMapa(valores,false);
            } catch (Exception e){
            }
        }

        //valores reales a imprimir
        int[] cants = {10,50,100,500,1000,1500,2000,4000,6000,8500};
        for (int i:cants){
            try{
                Map<String, String> valores = FileManager.leerArchivoCant("HM","cards_desc.txt",i);
                s+= "\n"+valores.size()+"\t"+ Controller.printMapa(valores,false);
            } catch (Exception e){
                s = "Error "+e.getMessage();
            }

        }

        return s;
    }

}
