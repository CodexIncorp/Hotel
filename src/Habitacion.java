


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
    String tipo_H;
    String tamaño;
    float precio;
    int noche;
    int extra;
    boolean ocupada;

    public Habitacion(String nombre, String tipo_H, String tamaño, float precio, int noche, int extra) {
        this.nombre = nombre;
        this.tipo_H = tipo_H;
        this.tamaño = tamaño;
        this.precio = precio;
        this.noche = noche;
        this.extra = extra;
        this.ocupada = false; // al principio todas las habitaciones están desocupadas
    }

    public abstract void calculo();
    public abstract void noches();
    public abstract void tamañoE();

    public void mostrarReserva() {
        System.out.println("--------------------------------");
        System.out.println("Reserva para: " + nombre);
        System.out.println("Tipo de habitación: " + tipo_H);
        System.out.println("Tamaño: " + tamaño);
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

    // es mi metodo pues para calcular el precio por noche dependiendo del tamaño de la habitacion
    public void calcularPrecioPorNoche() {
        // Precio base para habitacion estandar cuando es chica
        float precioBase = 3600;

        // aumenta 200 por tamaño en habitación estándar
        if (tipo_H.equalsIgnoreCase("Estandar")) {
            if (tamaño.equalsIgnoreCase("Mediana")) {
                precio = precioBase + 200;                                          // Aumento por tamaño Mediano
            } else if (tamaño.equalsIgnoreCase("Grande")) {
                precio = precioBase + 400;                                          // Aumento por tamaño Grande
            } else {
                precio = precioBase; // Precio base para tamaño Chica
            }
        }
        // aumento por tamaño en habitación suite
        else if (tipo_H.equalsIgnoreCase("Suite")) {
            if (tamaño.equalsIgnoreCase("Mediana")) {
                precio = precioBase + 400; // aumento por tamaño Mediano
            } else if (tamaño.equalsIgnoreCase("Grande")) {
                precio = precioBase + 600; // aumento por tamaño Grande
            } else {
                precio = precioBase + 300; // precio base para tamaño Chica en Suite
            }
        }
    }

    public float getPrecioFinal() {
        // Precio final: precio base + extra por personas + tamaño (aumento por tamaño) es para sacar pues el precio final XD
        float precioFinal = precio + (extra * 100); // El incremento por extra personas.
        return precioFinal * noche; // Multiplicamos por las noches reservadas.
    }
}



