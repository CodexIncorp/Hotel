/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ackwi
 */
public class Habitaciones {
    float precio;
    int numero_habitacion;
    Boolean disponibilidad;
    int n_camas;
    String tipo_cama;
    String wifi;
    private String clave_acceso;
    int horaI_servicio;
    int horaF_servicio;

    public Habitaciones(float precio, int numero_habitacion, Boolean disponibilidad, int n_camas, 
            String tipo_cama, String wifi, String clave_acceso, int horaI_servicio, int horaF_servicio) 
    {
        this.precio = precio;
        this.numero_habitacion = this.numero_habitacion;
        this.disponibilidad = disponibilidad;
        this.n_camas = n_camas;
        this.tipo_cama = tipo_cama;
        this.wifi = wifi;
        this.clave_acceso = clave_acceso;
        this.horaI_servicio = horaI_servicio;
        this.horaF_servicio = horaF_servicio;
    }
    
    public void reservar()
    {
        
    }
    
    public float metodoPago()
    {
        return 0;
    }

    public String getClaveAcceso() 
    {
        return clave_acceso;
    }

    public void setClaveAcceso(String clave_acceso) 
    {
        this.clave_acceso = clave_acceso;
    }
}
