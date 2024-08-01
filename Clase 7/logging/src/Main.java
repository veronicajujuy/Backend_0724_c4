import org.apache.log4j.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ListaEnteros listaEnteros = new ListaEnteros();
        double promedio;
        try{
            promedio = listaEnteros.promedio();
        }catch (Exception e){
            logger.error("se produjo un error "+ e.getMessage());
        }
        listaEnteros.agregarNumeros(5);
        listaEnteros.agregarNumeros(-10);
        listaEnteros.agregarNumeros(22);
        listaEnteros.agregarNumeros(45);
        listaEnteros.agregarNumeros(12);
        listaEnteros.agregarNumeros(7);
        try{
            promedio = listaEnteros.promedio();
        }catch (Exception e){
            logger.error("se produjo un error "+ e.getMessage());
        }
    }
}
