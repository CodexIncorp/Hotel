


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ackwi
 */
public abstract class Habitacion {
    String nombre;
    int tipo_H;
    int tamanio;
    float precio;
    int noche;
    int extra;
    boolean ocupada;

    public Habitacion(String nombre, int tipo_H, int tamanio, float precio, int noche, int extra) {
        this.nombre = nombre;
        this.tipo_H = tipo_H;
        this.tamanio = tamanio;
        this.precio = precio;
        this.noche = noche;
        this.extra = extra;
        this.ocupada = false; 
    }

    public abstract void calculo();
    public abstract void noches();
    public abstract void tamañoE();

    public void mostrarReserva() {
        System.out.println("--------------------------------");
        System.out.println("Reserva para: " + nombre);
        System.out.println("Tipo de habitación: " + tipo_H);
        System.out.println("Tamaño: " + tamanio);
        System.out.println("Precio por noche: " + precio);
        System.out.println("Precio final: " + getPrecioFinal());
        System.out.println("Noches reservadas: " + noche);
        System.out.println("Personas extras: " + extra);
        System.out.println("--------------------------------");
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void marcarOcupada() {
        this.ocupada = true;
    }

    public void marcarLibre() {
        this.ocupada = false;
    }

    // es mi metodo pues para calcular el precio por noche dependiendo del tamanio de la habitacion
    public void calcularPrecioPorNoche() {
    float aumento = 0;
    

    if (tipo_H == 1) { // Estandar
        if (tamanio == 2) {
            aumento = 200; // Mediana
        } else if (tamanio == 3) {
            aumento = 400; // Grande
        }
    } else if (tipo_H == 2) { // Suite
        if (tamanio == 1) {
            aumento = 300; // Chica
        } else if (tamanio == 2) {
            aumento = 400; // Mediana
        } else if (tamanio == 3) {
            aumento = 600; // Grande
        }
    }

    precio += aumento; // Aumentamos sobre el precio ingresado por el usuario
}


    public float getPrecioFinal() {
        // Precio final: precio base + extra por personas + tamanio (aumento por tamanio) es para sacar pues el precio final XD
        float precioFinal = precio + (extra * 100); // El incremento por extra personas.
        return precioFinal * noche; // multiplicamos por las noches reservadas.
    }
    
    @Override
public String toString() {
    return nombre + "," + tipo_H + "," + tamanio + "," + precio + "," + noche + "," + extra + "," + ocupada;
}
    
public static Habitacion fromString(String linea) {
    String[] datos = linea.split(",");
    String nombre = datos[0];
    int tipo_H = Integer.parseInt(datos[1]);
    int tamanio = Integer.parseInt(datos[2]);
    float precio = Float.parseFloat(datos[3]);
    int noche = Integer.parseInt(datos[4]);
    int extra = Integer.parseInt(datos[5]);
    boolean ocupada = Boolean.parseBoolean(datos[6]);

    Habitacion h;
    if (tipo_H == 1) {
        h = new Estandar(nombre, tipo_H, tamanio, precio, noche, extra);
    } else {
        h = new Suite(nombre, tipo_H, tamanio, precio, noche, extra);
    }
    if (ocupada) h.marcarOcupada();
    return h;
}

  

        
    
}



