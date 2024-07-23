package mesas;

public class Cuadrado extends Figura{
    public Cuadrado(Double medida) {
        super(medida);
    }

    @Override
    public String calculoArea() {
        if(getMedida() == 0) return "El valor del radio o lado debe ser mayor que cero";
        Double area = Math.pow(getMedida(),2);
        return "El área del cuadrado es "+ area +" unidades";
    }
}
