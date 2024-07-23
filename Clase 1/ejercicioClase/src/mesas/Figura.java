package mesas;

public abstract class Figura {
    private Double medida;

    public Figura(Double medida) {
        this.medida = medida;
    }

    public Double getMedida() {
        return medida;
    }

    public void setMedida(Double medida) {
        this.medida = medida;
    }

    public abstract String calculoArea();
}
