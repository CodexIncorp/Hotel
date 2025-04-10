
import java.util.ArrayList;

public class Clientes extends Usuarios {
    ArrayList<Habitacion> resrvas;

    public Clientes(ArrayList<Habitacion> resrvas, String nombre, int tipo, String correo, String telefono) {
        super(nombre, tipo, correo, telefono);
        this.resrvas = resrvas;
    }
    
    public void mostrarReservas()
    {
        //Creo que esto ya lo avanzó Sergio en otro lado; verificar.
    }
}
