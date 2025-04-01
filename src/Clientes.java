
import java.util.ArrayList;

public class Clientes extends Usuarios {
    ArrayList<Habitaciones> resrvas;

    public Clientes(ArrayList<Habitaciones> resrvas, String nombre, int tipo, String correo, String telefono) {
        super(nombre, tipo, correo, telefono);
        this.resrvas = resrvas;
    }
    
    public void mostrarReservas()
    {
        //Creo que esto ya lo avanzó Sergio en otro lado; verificar.
    }
}
