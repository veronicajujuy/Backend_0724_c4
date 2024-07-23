package mesas;

public abstract class PreparadorMenu {
    public String prepararMenu(Menu menu){
        String respuesta;
        respuesta = armadoDeMenu(menu);
        double costoTotal = calculoCosto(menu);
        respuesta += ". Total: "+ costoTotal;
        return respuesta;
    }
    public abstract String armadoDeMenu(Menu menu);
    public abstract double calculoCosto(Menu menu);
}
