package com.ht06;
import java.util.Map;
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
    public static String printMapa(Map<String,String> mapa){
        String s;
        if (mapa.isEmpty()){
            s="\nCollecion vacia";
        } else {
            s="\nCartas en la coleccion";
        }
        for (String carta: mapa.keySet()){
            s = s + "\n Nombre: "+carta +", Tipo: "+mapa.get(carta);
        }
        return s;
    }

    /**
     * Regresa un string listo para imprimir con todas las cartas del mapa
     * Ordenadas por tipo
     * @param mapa del que se quiere saber los objetos
     * @return
     */
    public static String printMapaOrdenado(Map<String,String> mapa){
        String s;

        return null;
    }

}
