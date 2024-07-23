package mesas;

public class Menu {
    private double precioBase;
    private int cantJuguetes;
    private int cantEspecias;
    private int cantSalsas;

    public Menu(double precioBase, int cantJuguetes, int cantEspecias, int cantSalsas) {
        this.precioBase = precioBase;
        this.cantJuguetes = cantJuguetes;
        this.cantEspecias = cantEspecias;
        this.cantSalsas = cantSalsas;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getCantJuguetes() {
        return cantJuguetes;
    }

    public void setCantJuguetes(int cantJuguetes) {
        this.cantJuguetes = cantJuguetes;
    }

    public int getCantEspecias() {
        return cantEspecias;
    }

    public void setCantEspecias(int cantEspecias) {
        this.cantEspecias = cantEspecias;
    }

    public int getCantSalsas() {
        return cantSalsas;
    }

    public void setCantSalsas(int cantSalsas) {
        this.cantSalsas = cantSalsas;
    }
}
