package clasepresencial;

public class Contratado extends Empleado {
    private int cantHoras;
    private double montoPorHora;

    public Contratado(String nombre, String apellido, String nroCuenta, int cantHoras, double montoPorHora) {
        super(nombre, apellido, nroCuenta);
        this.cantHoras = cantHoras;
        this.montoPorHora = montoPorHora;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public double getMontoPorHora() {
        return montoPorHora;
    }

    public void setMontoPorHora(double montoPorHora) {
        this.montoPorHora = montoPorHora;
    }
}
