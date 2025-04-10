public class Estandar extends Habitacion  {

    public Estandar(String nombre, String tipo_H, String tamaño, float precio, int noche, int extra) {
        super(nombre, tipo_H, tamaño, precio, noche, extra);
        calcularPrecioPorNoche(); 
    }

    @Override
    public void calculo() {
        System.out.println("El precio final de la habitación estandar es " + getPrecioFinal());
    }

    @Override
    public void noches() {
        System.out.println("Total por " + noche + " noches en habitacion estandar: " + (precio * noche));
    }

    @Override
    public void tamañoE() {
        System.out.println("Habitación Estandar - Tamaños disponibles: Chica, Mediana, Grande.");
    }

    public static void mostrarBeneficios() {
        System.out.println("Beneficios de la habitacion Estándar: WiFi gratuito, aire acondicionado, cama king size.");
    }
}
