package clasepresencial;

public class LiquidacionEfectivo extends Liquidacion{

    @Override
    public double calcularSueldo(Empleado empleado) {
        if(!(empleado instanceof Efectivo)) return 0;

        Efectivo empleadoEfectivo = ((Efectivo)empleado);
        return empleadoEfectivo.getSueldoBase() + empleadoEfectivo.getPremio() - empleadoEfectivo.getDescuento();
    }

    @Override
    public String imprimir(Empleado empleado) {
        return "impreso";
    }
}
