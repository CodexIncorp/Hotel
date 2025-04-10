
import java.util.ArrayList;
import java.util.Scanner;

public class Administradores extends Usuarios {

    ArrayList<Empleados> empleados;

    public Administradores(ArrayList<Empleados> empleados, String nombre, int tipo, String correo, String telefono) {
        super(nombre, tipo, correo, telefono);
        this.empleados = empleados;
    }

    public void agregarEmpleado() {
        String resp = "";
        int tipo_usuario = 2; //Empleado. Por convención.
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Ingrese el numero de empleado: ");
            String num_empleado = scan.nextLine();

            System.out.println("Ingrese el nombre: ");
            String nombre = scan.nextLine();

            System.out.println("Indique el puesto: ");
            String puesto = scan.nextLine();

            System.out.println("Indique la hora de entrada acordada: ");
            int hora_entra = Integer.parseInt(scan.nextLine());

            System.out.println("Indique la hora de salida acordada: ");
            int hora_salida = Integer.parseInt(scan.nextLine());

            Empleados empleado = new Empleados(num_empleado, puesto, hora_entra, hora_salida, nombre, tipo, "", "");
            empleados.add(empleado);

            System.out.println("Desea registrar a otro empleado? (S/N):");
            resp = scan.nextLine();
        } while (resp.equalsIgnoreCase("s"));
    }

    public void mostrarEmpleados() {
        System.out.println("La informacion de los empleados con los que cuenta es la siguiente:");

        for (Empleados empleado : empleados) {
            System.out.println("Numero de empleado: " + empleado.num_empleado);
            System.out.println("Nombre: " + empleado.nombre);
            System.out.println("Puesto: " + empleado.puesto);
            System.out.println("Horario: " + empleado.hora_entrada + " - " + empleado.hora_salida);
        }
    }

    public void removerEmpleado() {
        Scanner scan = new Scanner(System.in);

        System.out.println("La informacion de los empleados con los que cuenta es la siguiente:");

        for (Empleados empleado : empleados) {
            System.out.println("Numero de empleado: " + empleado.num_empleado);
            System.out.println("Nombre: " + empleado.nombre);
            System.out.println("Puesto: " + empleado.puesto);
            System.out.println("Horario: " + empleado.hora_entrada + " - " + empleado.hora_salida);
        }

        System.out.println("Indique el numero de empleado que desea remover de la plantilla:");
        String num_empleado = scan.nextLine();

        System.out.println("Esta seguro de remover a este empleado? (S/N)");
        String resp = scan.nextLine();

        if (resp.equalsIgnoreCase("s")) {
            for (Empleados empleado : empleados) {
                if (empleado.num_empleado.equalsIgnoreCase(num_empleado)) {
                    empleados.remove(empleado);
                    System.out.println("Se ha removido correctamente al empleado de lam plantilla.");
                    break;
                }
            }
        }
    }
}
