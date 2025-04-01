
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

    static boolean error = true;

    public static void main(String[] args) {
        int nHabitacion = 0, i, habitacion = 0;
        int noche = 0, ext = 0;
        String nombre, Elec = "", tamaño, re, accion, otra_accion = "";

        ArrayList<Estandar> cl = new ArrayList<>();
        ArrayList<Suite> cl2 = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        login();

        if (nHabitacion == 0) {
            System.out.println("Ingrese el numero de habitaciones totales:");
            nHabitacion = input.nextInt();
        }

        ArrayList<Boolean> estandar = new ArrayList<>(Collections.nCopies(nHabitacion, true));
        input.nextLine();

        int reservaEstandar = 1; // Contador de reservas Estándar
        int reservaSuite = 1;    // Contador de reservas Suite

        do {
            System.out.println("¿Que accion quiere realizar? (check in / check out)");
            String chek = input.nextLine();

            if (chek.equalsIgnoreCase("check in")) {
                boolean habitacionAsignada = false;

                for (i = 0; i < nHabitacion; i++) {
                    if (estandar.get(i)) {
                        System.out.println("Su numero de habitacion sera " + (i + 1));
                        habitacion = i + 1;
                        estandar.set(i, false);
                        habitacionAsignada = true;
                        break;
                    }
                }

                if (!habitacionAsignada) {
                    System.out.println("Lo sentimos, no hay habitaciones disponibles.");
                    continue;
                }

                System.out.println("Ingrese el nombre del cliente a reservar:");
                nombre = input.nextLine();

                do {
                    System.out.println("Seleccione el tipo de habitacion:");
                    System.out.println("1 - Estándar\n2 - Suite");
                    Elec = input.nextLine();

                    if (Elec.equalsIgnoreCase("1")) {

                        Estandar objE = new Estandar("", 0, "0", "0", 0, 0, 0);
                        objE.precE();
                        objE.inf_E();
                    } else if (Elec.equals("2")) {
                        Suite objS = new Suite("", 0, "0", "0", 0, 0, 0);
                        objS.precS();
                        objS.inf_S();
                    } else {
                        System.out.println("Opcion no valida. Intente de nuevo.");
                    }

                    System.out.println("¿Está seguro de su elección? (si/no)");
                    re = input.nextLine();

                    //correguir poner un while
                } while (!Elec.equalsIgnoreCase("1") && !Elec.equalsIgnoreCase("2"));

                if (re.equalsIgnoreCase("no")) {
                    System.out.println("Reserva cancelada.");
                    estandar.set(habitacion - 1, true);
                    continue;
                }

                if (Elec.equals("1")) {
                    Elec = "Estandar";
                } else {
                    Elec = "Suite";
                }

                System.out.println("Usted eligió la habitación " + Elec);

                // El tamaño de la habitación
                System.out.println("Elija el tamaño de la habitación:");
                if ((Elec).equalsIgnoreCase("Estandar")) {
                    Estandar objE = new Estandar("", 0, "0", "0", 0, 0, 0);
                    objE.tamañoE();
                } else {
                    Suite objS = new Suite("", 0, "0", "0", 0, 0, 0);
                    objS.tamañoE();
                }

                tamaño = input.nextLine();

                // estas pues son la noches
                System.out.println("¿Cuántas noches desea reservar?");
                noche = input.nextInt();
                input.nextLine(); // Limpiar buffer

                // Personas extras
                System.out.println("¿Desea agregar hasta 2 personas extras? (si/no)");
                String R = input.nextLine();
                if (R.equalsIgnoreCase("si")) {
                    System.out.println("Ingrese el número de personas a agregar (máximo 2):");
                    ext = input.nextInt();
                    input.nextLine(); // Limpiar buffer
                }

                // este me agrega lo que es la reserva
                if (Elec.equals("Estandar")) {
                    Estandar objE = new Estandar(nombre, habitacion, Elec, tamaño, 3600, ext, noche);
                    objE.noches();
                    cl.add(objE);
                    System.out.println("Reserva Estándar " + reservaEstandar);
                    reservaEstandar++;
                } else {
                    Suite objS = new Suite(nombre, habitacion, Elec, tamaño, 8999, noche, ext);
                    objS.noches();
                    cl2.add(objS);
                    System.out.println("Reserva Suite " + reservaSuite);
                    reservaSuite++;
                }

                // preg si deseas otra reserva
                System.out.println("¿Desea realizar otra reserva? (si/no)");
                accion = input.nextLine();

            } else if (chek.equalsIgnoreCase("check out")) {
                System.out.println("Ingrese el número de habitación para hacer check out:");
                int numCheckOut = input.nextInt();
                input.nextLine();

                if (numCheckOut < 1 || numCheckOut > nHabitacion) {
                    System.out.println("Número de habitación inválido.");
                } else if (estandar.get(numCheckOut - 1)) {
                    System.out.println("La habitación ya está libre.");
                } else {
                    estandar.set(numCheckOut - 1, true);
                    System.out.println("Check out exitoso. Habitación liberada.");
                }
            } else {
                System.out.println("Opción no válida.");
            }

            // Preguntar si desea realizar otra acción
            System.out.println("¿Desea realizar otra acción? (si/no)");
            otra_accion = input.nextLine();

        } while (otra_accion.equalsIgnoreCase("si"));

        //este me sirve que es para que me cuente al final las reservas
        System.out.println("Tickets Estándar");
        for (int j = 0; j < cl.size(); j++) {

            cl.get(j).MostrarE(cl);
        }

        System.out.println("Tickets Suite");
        for (int j = 0; j < cl2.size(); j++) {

            cl2.get(j).MostrarS(cl2);
        }

        Habitaciones obje = new Habitaciones("", 0, "", "", 0, 0, 0);

    }

    public static void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al Hotel HostBint");
        System.out.println("Por favor, indique su tipo de usuario:");
        System.out.println("1. Administrador");
        System.out.println("2. Empleado");
        System.out.println("3. Cliente");
        while (error) {
            try {
                int tipo_usuario = Integer.parseInt(scan.nextLine());
                error = false;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                error = true;
            }
        }
    }
}
