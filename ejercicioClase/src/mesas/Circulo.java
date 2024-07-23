package mesas;

import java.text.DecimalFormat;

public class Circulo extends Figura{
    public Circulo(Double medida) {
        super(medida);
    }

    @Override
    public String calculoArea() {
        if(getMedida() == 0) return "El valor del radio o lado debe ser mayor que cero";
        Double area = Math.pow(getMedida(),2) * Math.PI;
        DecimalFormat df = new DecimalFormat("#.00");
        return "El área del círculo es "+ df.format(area)  +" unidades";
    }
}
