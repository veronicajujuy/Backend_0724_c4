import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaEnteros {
    public static final Logger logger = Logger.getLogger(ListaEnteros.class);
    List<Integer> enteros = new ArrayList<>();

    public void agregarNumeros(Integer numero){
        enteros.add(numero);
        logger.debug("el numero que se agrego es "+ numero);
        if(enteros.size() > 5){
            logger.info("La lista tiene mas de 5 elementos");
        }
        if(enteros.size() > 10){
            logger.info("La lista tiene mas de 10 elementos");
        }
    }

    public double promedio(){
        if(enteros.isEmpty()){
            throw new RuntimeException("La lista no tiene elementos");
        }
        int suma = 0;
        for(Integer numero: enteros){
            suma += numero;
        }
        double promedioARetornar = (double)suma / enteros.size();
        logger.info("el promedio es : "+promedioARetornar );
        return promedioARetornar;
    }

    public Integer maximo(){
        Integer maximo = Integer.MIN_VALUE;
        for(Integer numero: enteros){
            if(numero > maximo){
                maximo = numero;
            }
        }
        logger.info("el maximo es:" + maximo);
        return maximo;
    }

    public Integer minimo(){
        Integer minimo = Integer.MAX_VALUE;
        for(Integer numero: enteros){
            if(numero < minimo){
                minimo = numero;
            }
        }
        logger.info("el minimo es:" + minimo);
        return minimo;
    }
}
