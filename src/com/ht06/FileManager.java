package com.ht06;
import java.io.File;
import java.util.Scanner;
import java.util.Map;

/**
 * Ultima modificacion: 9/03/2022
 *
 * Clase en la que se maneja archivos
 * @file FileManager.java
 * @author Montserrat Gil
 * @author Guillermo Santos
 */


public class FileManager {

    /**
     * Lee un archivo y devuelve el mapa con el contenido del mismo
     * @param tipoHash implementacion del hash que se quiere
     * @param archivo direccion del archivo
     * @return mapa
     * @throws Exception
     */
    public static Map<String, String> leerArchivo(String tipoHash, String archivo) throws Exception{
        HashMapFactory<String, String> hashF = new HashMapFactory<String,String>();
        Map<String, String> hash = hashF.getMap(tipoHash);
        try{
            File file = new File(archivo);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()){
                String linea = s.nextLine();
                String[] items = linea.split("\\|");
                hash.put(items[0],items[1]);
            }
            s.close();
        } catch (Exception e){
            throw new Exception("Error al leer el archivo");
        }
        return hash;
    }

}
