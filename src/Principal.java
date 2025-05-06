



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static int numEstandar, numSuite;
    static float precioEstandar, precioSuite;

    public static void main(String[] args) {
        ArrayList<Habitacion> reservas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Validador<Integer> scani = new Validador<>();
        Validador<String> scans = new Validador<>();

        int tipoH, tamanio;
        String nombre;
        int noche, extra;

        System.out.println("Bienvenido al Hotel HostBints");

        cargarConfiguracionYReservas(reservas);

        while (true) {
            System.out.println("\nSeleccione una accion:");
            System.out.println("[1] Check in");
            System.out.println("[2] Check out");
            System.out.println("[3] Mostrar reservas");
            System.out.println("[4] Salir");
            System.out.println("[5] Editar reserva");
            System.out.println("[6] Eliminar reserva");

            int opcion = scani.validarEntrada(Integer.class);
            opcion = scani.validarRango(1, 6, opcion);

            switch (opcion) {
                case 1:
                    boolean habitacionAsignada = false;

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

                    System.out.println("Cuantas personas extras?");
                    extra = scani.validarEntrada(Integer.class);

                    System.out.println("Ingrese el nombre del cliente:");
                    nombre = scans.validarEntrada(String.class);

                    int inicio, fin;
                    if (tipoH == 1) {
                        inicio = 0;
                        fin = numEstandar;
                    } else {
                        inicio = numEstandar;
                        fin = numEstandar + numSuite;
                    }

                    for (int i = inicio; i < fin; i++) {
                        if (reservas.get(i) == null || !reservas.get(i).isOcupada()) {
                            Habitacion habitacion;
                            if (tipoH == 1) {
                                habitacion = new Estandar(nombre, tipoH, tamanio, precioEstandar, noche, extra);
                            } else {
                                habitacion = new Suite(nombre, tipoH, tamanio, precioSuite, noche, extra);
                            }

                            habitacion.marcarOcupada();
                            reservas.set(i, habitacion);

                            System.out.println("Reserva realizada con exito. Su numero de habitacion es: " + (i + 1));
                            habitacionAsignada = true;
                            break;
                        }
                    }

                    if (!habitacionAsignada) {
                        System.out.println("Lo siento, no hay habitaciones disponibles de ese tipo.");
                    }

                    guardarReservas(reservas);
                    break;

                case 2:
                    System.out.println("Ingrese el numero de habitacion para hacer check out:");
                    int numCheckOut = scani.validarEntrada(Integer.class);

                    if (numCheckOut < 1 || numCheckOut > (numEstandar + numSuite)) {
                        System.out.println("Numero de habitación invalido.");
                    } else if (reservas.get(numCheckOut - 1) == null || !reservas.get(numCheckOut - 1).isOcupada()) {
                        System.out.println("La habitación ya está libre.");
                    } else {
                        reservas.get(numCheckOut - 1).marcarLibre();
                        System.out.println("Check out exitoso. La habitacion ha sido liberada.");
                    }

                    guardarReservas(reservas);
                    break;

                case 3:
                    System.out.println("\nHabitaciones Estandar:");
                    for (int i = 0; i < numEstandar; i++) {
                        System.out.print("Habitacion " + (i + 1) + ": ");
                        if (reservas.get(i) != null && reservas.get(i).isOcupada()) {
                            reservas.get(i).mostrarReserva();
                        } else {
                            System.out.println("Libre");
                        }
                    }

                    System.out.println("\nHabitaciones Suite:");
                    for (int i = numEstandar; i < numEstandar + numSuite; i++) {
                        System.out.print("Habitacion " + (i + 1) + ": ");
                        if (reservas.get(i) != null && reservas.get(i).isOcupada()) {
                            reservas.get(i).mostrarReserva();
                        } else {
                            System.out.println("Libre");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    return;

                case 5:
                    System.out.println("Ingrese el numero de habitacion a editar:");
                    int numEditar = scani.validarEntrada(Integer.class);

                    if (numEditar < 1 || numEditar > (numEstandar + numSuite)) {
                        System.out.println("Numero de habitacion invalido.");
                    } else if (reservas.get(numEditar - 1) == null || !reservas.get(numEditar - 1).isOcupada()) {
                        System.out.println("La habitación esta libre. No hay reserva que editar.");
                    } else {
                        System.out.println("Ingrese nuevo nombre del cliente:");
                        nombre = scans.validarEntrada(String.class);
                        System.out.println("Ingrese nuevo numero de noches:");
                        noche = scani.validarEntrada(Integer.class);
                        System.out.println("Ingrese nuevas personas extras:");
                        extra = scani.validarEntrada(Integer.class);

                        Habitacion h = reservas.get(numEditar - 1);
                        h.nombre = nombre;
                        h.noche = noche;
                        h.extra = extra;
                        h.getPrecioFinal();

                        System.out.println("Reserva actualizada con exito.");
                        guardarReservas(reservas);
                    }
                    break;

               case 6:
    System.out.println("Desea eliminar el archivo de reservas y las reservas en memoria? (S/N):");
    String respuesta = scans.validarEntrada(String.class).toUpperCase();  // Leer respuesta de sí/no

    if (respuesta.equals("S")) {
        // Eliminar archivo reservas.txt
        File archivo = new File("reservas.txt");
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("El archivo de reservas ha sido eliminado.");
            } else {
                System.out.println("Hubo un error al eliminar el archivo de reservas.");
            }
        } else {
            System.out.println("El archivo de reservas no existe.");
        }

        // Limpiar el ArrayList de reservas
        reservas.clear();
        System.out.println("Las reservas en memoria han sido eliminadas.");

        // Si deseas inicializar de nuevo el ArrayList (en caso de que quieras reiniciar las habitaciones)
        for (int i = 0; i < (numEstandar + numSuite); i++) {
            reservas.add(null);  // Vuelve a agregar las habitaciones como vacías
        }

    } else {
        System.out.println("No se ha eliminado el archivo de reservas ni las reservas en memoria.");
    }
    break;


    
            }
        }
    }
        
    
    public static void guardarConfiguracion(int numEstandar, float precioEstandar, int numSuite, float precioSuite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("configuracion.txt"))) {
            bw.write(numEstandar + "," + precioEstandar + "," + numSuite + "," + precioSuite);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("error al guardar la configuracion: " + e.getMessage());
        }
    }

    public static void cargarConfiguracionYReservas(ArrayList<Habitacion> reservas) {
    File archivoConfig = new File("configuracion.txt");
    File archivoReservas = new File("reservas.txt");

    if (archivoConfig.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoConfig))) {
            String[] datos = br.readLine().split(",");
            numEstandar = Integer.parseInt(datos[0]);
            precioEstandar = Float.parseFloat(datos[1]);
            numSuite = Integer.parseInt(datos[2]);
            precioSuite = Float.parseFloat(datos[3]);

            for (int i = 0; i < (numEstandar + numSuite); i++) {
                reservas.add(null);
            }

        } catch (IOException e) {
            System.out.println("error al cargar la configuracion: " + e.getMessage());
        }
    } else {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero de habitaciones estandar: ");
        numEstandar = sc.nextInt();

        System.out.print("Ingrese el precio base por noche para habitacion estandar: ");
        precioEstandar = sc.nextFloat();

        System.out.print("Ingrese el numero de habitaciones suite: ");
        numSuite = sc.nextInt();

        System.out.print("Ingrese el precio base por noche para habitacion suite: ");
        precioSuite = sc.nextFloat();

        guardarConfiguracion(numEstandar, precioEstandar, numSuite, precioSuite);

        for (int i = 0; i < (numEstandar + numSuite); i++) {
            reservas.add(null);
        }
    }

    if (archivoReservas.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoReservas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                try {
                    int index = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int tipo = Integer.parseInt(datos[2]);
                    int tamanio = Integer.parseInt(datos[3]);
                    float precio = Float.parseFloat(datos[4]);
                    int noches = Integer.parseInt(datos[5]);
                    int extra = Integer.parseInt(datos[6]);

                    Habitacion habitacion;
                    if (tipo == 1) {
                        habitacion = new Estandar(nombre, tipo, tamanio, precio, noches, extra);
                    } else {
                        habitacion = new Suite(nombre, tipo, tamanio, precio, noches, extra);
                    }

                    habitacion.marcarOcupada();
                    reservas.set(index, habitacion);
                } catch (NumberFormatException e) {
                    System.out.println("Error al procesar la linea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las reservas: " + e.getMessage());
        }
    }
}

   public static void guardarReservas(ArrayList<Habitacion> reservas) {
    File archivo = new File("reservas.txt");

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {  // Cambié el 'true' por el modo por defecto (sobrescribir)
        for (int i = 0; i < reservas.size(); i++) {
            Habitacion h = reservas.get(i);
            if (h != null && h.isOcupada()) {
                bw.write(i + "," + h.nombre + "," + h.tipo_H + "," + h.tamanio + "," + h.precio + "," + h.noche + "," + h.extra);
                bw.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("Error al guardar las reservas: " + e.getMessage());
    }
}

}
