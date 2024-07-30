package model;

public class Arbol {
    private String tipo;
    private int alto;
    private int horizontal;
    private String color;

    public Arbol(String tipo, int alto, int horizontal, String color) {
        this.tipo = tipo;
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
