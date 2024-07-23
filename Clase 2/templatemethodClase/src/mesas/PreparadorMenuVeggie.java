package mesas;

public class PreparadorMenuVeggie extends PreparadorMenu{
    @Override
    public String armadoDeMenu(Menu menu) {
        return "Armando menu Vegetariano";
    }

    @Override
    public double calculoCosto(Menu menu) {
        return menu.getPrecioBase() + (menu.getPrecioBase()*0.01* menu.getCantEspecias())+ 2* menu.getCantSalsas();
    }
}
