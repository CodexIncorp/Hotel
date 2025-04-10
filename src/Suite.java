public class Suite extends Habitacion {

    public Suite(String nombre, String tipo_H, String tamaño, float precio, int noche, int extra) {
        super(nombre, tipo_H, tamaño, precio, noche, extra);
        calcularPrecioPorNoche(); // calculamos el precio por noche al crear la habitacion
    }

    @Override
    public void calculo() {
        System.out.println("El precio final de la suite es " + getPrecioFinal());
    }

    @Override
    public void noches() {
        System.out.println("Total por " + noche + " noches en suite: " + (precio * noche));
    }

    @Override
    public void tamañoE() {
        System.out.println("Habitacion Suite - Tamaños disponibles: Chica, Mediana, Grande.");
    }

    public static void mostrarBeneficios() {
        System.out.println("Beneficios de la Suite: Vista panoramica, camas grandes, WiFi exclusivo, jacuzzi.");
    }
}



