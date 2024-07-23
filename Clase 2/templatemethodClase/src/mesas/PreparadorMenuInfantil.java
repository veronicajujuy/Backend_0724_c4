package mesas;

public class PreparadorMenuInfantil extends PreparadorMenu{
    @Override
    public String armadoDeMenu(Menu menu) {
        return "Armando menu infantil";
    }

    @Override
    public double calculoCosto(Menu menu) {
        return menu.getPrecioBase() + 3*menu.getCantJuguetes();
    }
}
