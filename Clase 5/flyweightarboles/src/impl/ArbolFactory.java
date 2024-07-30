package impl;

import model.Arbol;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static Map<String, Arbol> poolArboles = new HashMap<>();

    public static Arbol getArbol(String tipo, int alto, int horizontal, String color){
        String clave = "key: "+ tipo+alto+horizontal+color;
        if(!poolArboles.containsKey(clave)) {
            System.out.println("arbol creado " + clave);
            poolArboles.put(clave, new Arbol(tipo, alto, horizontal, color));
        }
            System.out.println("arbol obtenido "+ clave);
            return poolArboles.get(clave);

    }
}
