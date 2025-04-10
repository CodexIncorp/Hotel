
import java.util.Scanner;

public class Validador<T> {

    private Scanner scan;

    public Validador() {
        this.scan = new Scanner(System.in);
    }

    public T validarEntrada(Class<T> tipo) {
        while (true) {
            try {
                if (tipo == Integer.class) {
                    return tipo.cast(scan.nextInt());
                } else if (tipo == Float.class) {
                    return tipo.cast(scan.nextFloat());
                } else if (tipo == Double.class) {
                    return tipo.cast(scan.nextDouble());
                } else if (tipo == String.class) {
                    return tipo.cast(scan.nextLine());
                } else {
                    throw new IllegalArgumentException("Tipo de dato no soportado");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un valor valido de tipo " + tipo + ": ");
                scan.next();
            }
        }
    }

    public void validarRango(int inicio, int fin, int entrada) {
        boolean error = false;
        if (entrada < inicio || entrada > fin) {
            while (error) {
                System.out.println("Ingrese un valor entero entre " + inicio + " y " + fin + ": ");
                scan.next();
                error = true;
            }
        } else {
            error = false;
        }
    }
}
