package clasepresencial;

public abstract class Liquidacion {
    public String liquidarSueldo(Empleado empleado){
        String respuesta = "La liquidación no pudo ser calculada";
        //1. calcular sueldo
        double sueldo = calcularSueldo(empleado);
        if(sueldo == 0) return  respuesta;
        //2. Imprimir comprobante
        String impresion = imprimir(empleado);
        //3. despositar
        depositarSueldo(empleado);
        respuesta = "La liquidación generada es un documento " + impresion +
                ". Saldo a liquidar: "+ sueldo;
        return respuesta;
    }

    protected abstract double calcularSueldo(Empleado empleado);
    protected abstract String imprimir(Empleado empleado);
    private void depositarSueldo(Empleado empleado){
        System.out.println("Sueldo depositado " +
                "al empleado: "+ empleado.getApellido());
    }

}
