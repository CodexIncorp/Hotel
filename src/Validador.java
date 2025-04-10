
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
                System.out.println("Ingrese un valor valido segun lo especificado: ");
                scan.next();
            }
        }
    }

    public int validarRango(int inicio, int fin, int entrada) {
        boolean error = true;
        Validador<Integer> scani = new Validador<>();
        
        while (error) {
            if (entrada < inicio || entrada > fin) {
                System.out.println("Ingrese un valor entero entre " + inicio + " y " + fin + ": ");
                entrada = scani.validarEntrada(Integer.class);
            } else {
                error = false;
            }
        }
        return entrada;
    }
}
