package com.ht06;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Hash Map Factory creates different implementations of a Java Map.
 * @param <K> Type for the key
 * @param <V> Type for the value
 * @file HashMapFactory.java
 * @author Montserrat Gil
 * @author Guillermo Santos
 */
public class HashMapFactory<K,V> {

    /**
     * Creates a Map with a different implementation depending on the option parameter.
     * @param option Type of Map to return. (HM -> HashMap) (LM -> LinkedHashMap) (TM -> TreeMap)
     * @return
     * @throws Exception
     */
    public Map<K, V> getMap(String option) throws Exception {
        if (option.equalsIgnoreCase("HM")) {
            return new HashMap<K, V>(); // HashMap
        } else if (option.equalsIgnoreCase("LM")) {
            return new LinkedHashMap<K,V>();    // LinkedHashMap
        } else if(option.equalsIgnoreCase("TM")) {
            return new TreeMap<K,V>();  // TreeMap
        } else {
            throw new Exception("El tipo de Mapa seleccionado no es valido.");  // Throw error message
        }
    }
}
