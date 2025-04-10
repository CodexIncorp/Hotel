public class Empleados extends Usuarios {
    String num_empleado;
    String puesto;
    int hora_entrada;
    int hora_salida;

    public Empleados(String num_empleado, String puesto, int hora_entrada, int hora_salida, String nombre, int tipo, String correo, String telefono) {
        super(nombre, tipo, correo, telefono);
        this.num_empleado = num_empleado;
        this.puesto = puesto;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }
    
    
    public void calculoPago()
    {
        //Calcular el pago correspondiente del empleado.
    }
}
