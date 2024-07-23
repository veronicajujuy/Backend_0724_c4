package clasepresencial;

public class LiquidacionContratado extends Liquidacion{
    @Override
    public double calcularSueldo(Empleado empleado) {
        if(!(empleado instanceof Contratado)) return 0;
        Contratado contratado = ((Contratado)empleado);
        return contratado.getCantHoras() * contratado.getMontoPorHora();
    }

    @Override
    public String imprimir(Empleado empleado) {
        return "digital";
    }
}
