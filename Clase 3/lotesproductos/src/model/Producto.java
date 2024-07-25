package model;

public class Producto {
    private String nombre;
    private int lote;
    private int peso;
    private Envasado envasado;

    public Producto(String nombre, int lote, int peso, Envasado envasado) {
        this.nombre = nombre;
        this.lote = lote;
        this.peso = peso;
        this.envasado = envasado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Envasado getEnvasado() {
        return envasado;
    }

    public void setEnvasado(Envasado envasado) {
        this.envasado = envasado;
    }
}
