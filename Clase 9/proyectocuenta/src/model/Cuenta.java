package model;

public class Cuenta {
    private Integer id;
    private String nroCuenta;
    private String nombre;
    private double saldo;

    public Cuenta(String nroCuenta, String nombre, double saldo) {
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Cuenta(Integer id, String nroCuenta, String nombre, double saldo) {
        this.id = id;
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", nroCuenta='" + nroCuenta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
