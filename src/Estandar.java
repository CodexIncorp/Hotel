/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ackwi
 */
public class Estandar extends Habitaciones {
    int capacidad_max;

    public Estandar(int capacidad_max, float precio, int numero_habitacion, Boolean disponibilidad, 
            int n_camas, String tipo_cama, String wifi, String clave_acceso, int horaI_servicio, 
            int horaF_servicio) 
    {
        super(precio, numero_habitacion, disponibilidad, n_camas, tipo_cama, wifi, clave_acceso, 
                horaI_servicio, horaF_servicio);
        this.capacidad_max = capacidad_max;
    }
    
    //Añadir métodos...
}
