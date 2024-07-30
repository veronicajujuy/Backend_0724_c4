package model;

public class Computadora {
    private String tipo;
    private int ram;
    private int discoRigido;
    private static int contador = 0;

    public Computadora(String tipo, int ram, int discoRigido) {
        this.tipo = tipo;
        this.ram = ram;
        this.discoRigido = discoRigido;
        contador++;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDiscoRigido() {
        return discoRigido;
    }

    public void setDiscoRigido(int discoRigido) {
        this.discoRigido = discoRigido;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Computadora.contador = contador;
    }
}
