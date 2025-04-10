     


import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Habitacion> reservas = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int nHabitaciones;
        String nombre, tipoH, tamaño;
        int noche, extra;

        System.out.println("Bienvenido al Hotel HostBints");
        input.nextLine();
        
        System.out.print("Ingrese el numero de habitaciones en el hotel: ");
        nHabitaciones = input.nextInt();
        
        input.nextLine(); 

        // esto pues crea las habitaciones disponibles
        for (int i = 0; i < nHabitaciones; i++) {
            reservas.add(null);             // inicialmente, todas las habitaciones están vacías
        }

        while (true) {
            System.out.println("\nSeleccione una accion:");
            System.out.println("1 - Check in");
            System.out.println("2 - Check out");
            System.out.println("3 - Mostrar reservas");
            System.out.println("4 - Salir");

            int opcion = input.nextInt();
            input.nextLine();  

            switch (opcion) {
                case 1:
                   
                   
                    boolean habitacionAsignada = false;

                    // Mostrar los beneficios antes de elegir la habitacion
                    System.out.println("\nBeneficios disponibles:");
                   
                    Estandar.mostrarBeneficios();
                    Suite.mostrarBeneficios();
                    
                    System.out.println("\nSeleccione tipo de habitacion (Estandar/Suite):");
                    tipoH = input.nextLine();

                    
                    System.out.println("Seleccione el tamaño de la habitacion (Chica/Mediana/Grande):");
                    tamaño = input.nextLine();

                    System.out.println("Ingrese el numero de noches:");
                    noche = input.nextInt();

                    System.out.println("¿Cuantas personas extras?");
                    extra = input.nextInt();
                    input.nextLine();  

                   
                    for (int i = 0; i < nHabitaciones; i++) {
                        if (reservas.get(i) == null || !reservas.get(i).isOcupada()) {
                            System.out.println("Su numero de habitacion es: " + (i + 1));
                            System.out.println("Ingrese el nombre del cliente:");
                            nombre = input.nextLine();

                            if (tipoH.equalsIgnoreCase("Estandar")) {
                                Habitacion habitacion = new Estandar(nombre, tipoH, tamaño, 3600, noche, extra);
                                reservas.set(i, habitacion);
                            } else if (tipoH.equalsIgnoreCase("Suite")) {
                                Habitacion habitacion = new Suite(nombre, tipoH, tamaño, 3600, noche, extra);
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
                    int numCheckOut = input.nextInt();
                    input.nextLine();  

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
                    input.close();
                    return;

                default:
                    System.out.println("Error, elige una accion mostrada anteriormente.");
                    break;
            }
        }
    }
}


