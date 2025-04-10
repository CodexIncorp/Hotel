
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Habitacion> reservas = new ArrayList<>();
        //Objetos de tipo validador que implementan la clase Scanner con excepciones
        Validador<Integer> scani = new Validador<>();
//        Validador<Float> scanf = new Validador<>();
//        Validador<Double> scand = new Validador<>();
        Validador<String> scans = new Validador<>();

        int nHabitaciones, tipoH, tamanio;
        String nombre;
        int noche, extra;

        System.out.println("Bienvenido al Hotel HostBints");

        System.out.print("Ingrese el numero de habitaciones en el hotel: ");
        nHabitaciones = scani.validarEntrada(Integer.class);

        // Esto crea las habitaciones disponibles
        for (int i = 0; i < nHabitaciones; i++) {
            reservas.add(null);             // inicialmente, todas las habitaciones están vacías
        }

        System.out.println("\nSeleccione una accion:");
        System.out.println("[1] Check in");
        System.out.println("[2] Check out");
        System.out.println("[3] Mostrar reservas");
        System.out.println("[4] Salir");
        int opcion = scani.validarEntrada(Integer.class);
        opcion = scani.validarRango(1, 4, opcion);

        switch (opcion) {
            case 1:

                boolean habitacionAsignada = false;

                // Mostrar los beneficios antes de elegir la habitacion
                System.out.println("\nBeneficios disponibles:");

                Estandar.mostrarBeneficios();
                Suite.mostrarBeneficios();

                System.out.println("\nSeleccione tipo de habitacion:");
                System.out.println("[1] Estandar");
                System.out.println("[2] Suite");
                tipoH = scani.validarEntrada(Integer.class);
                tipoH = scani.validarRango(1, 2, tipoH);

                System.out.println("Seleccione el tamaño de la habitacion:");
                System.out.println("[1] Chica");
                System.out.println("[2] Mediana");
                System.out.println("[3] Grande");
                tamanio = scani.validarEntrada(Integer.class);
                tamanio = scani.validarRango(1, 3, tamanio);

                System.out.println("Ingrese el numero de noches:");
                noche = scani.validarEntrada(Integer.class);

                System.out.println("¿Cuantas personas extras?");
                extra = scani.validarEntrada(Integer.class);

                for (int i = 0; i < nHabitaciones; i++) {
                    if (reservas.get(i) == null || !reservas.get(i).isOcupada()) {
                        System.out.println("Su numero de habitacion es: " + (i + 1));
                        System.out.println("Ingrese el nombre del cliente:");
                        nombre = scans.validarEntrada(String.class);

                        if (tipoH == 1) {//Estandar
                            Habitacion habitacion = new Estandar(nombre, tipoH, tamanio, 3600, noche, extra);
                            reservas.set(i, habitacion);
                        } else if (tipoH == 2) {//Suite
                            Habitacion habitacion = new Suite(nombre, tipoH, tamanio, 3600, noche, extra);
                            reservas.set(i, habitacion);
                        }
                        reservas.get(i).marcarOcupada();
                        habitacionAsignada = true;
                        System.out.println("Reserva realizada con exito.");
                        break;
                    }
                }
                if (!habitacionAsignada) {
                    System.out.println("Lo siento, no hay habitaciones disponibles.");
                }
                break;

            case 2:

                System.out.println("Ingrese el numero de habitacion para hacer check out:");
                int numCheckOut = scani.validarEntrada(Integer.class);

                if (numCheckOut < 1 || numCheckOut > nHabitaciones) {
                    System.out.println("numero de habitacion invalido.");
                } else if (reservas.get(numCheckOut - 1) == null || !reservas.get(numCheckOut - 1).isOcupada()) {
                    System.out.println("La habitacion ya esta libre.");
                } else {
                    reservas.get(numCheckOut - 1).marcarLibre();
                    System.out.println("Check out exitoso..... La habitación ha sido liberada.");
                }
                break;

            case 3://muestra mis reservas
                System.out.println("Lista de reservas:");
                for (int i = 0; i < nHabitaciones; i++) {
                    if (reservas.get(i) != null && reservas.get(i).isOcupada()) {
                        System.out.println("Habitacion " + (i + 1) + ":");
                        reservas.get(i).mostrarReserva();
                    } else {
                        System.out.println("Habitacion " + (i + 1) + " esta libre.");
                    }
                }
                break;

            case 4:

                System.out.println("Saliendo...");
                return;

            default:
                System.out.println("Error, elige una accion mostrada anteriormente.");
                break;
        }
    }
}
