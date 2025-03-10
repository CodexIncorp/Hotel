/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ackwi
 */
public class Suite extends Habitaciones {
    String vista;
    int cuartos;
    private String wifi_priv;
    Boolean jacuzzi;
    Boolean terraza;
    String[] servicios_vip;

    public Suite(String vista, int cuartos, String wifi_priv, Boolean jacuzzi, Boolean terraza, 
            String[] servicios_vip, float precio, int numero_habitacion, Boolean disponibilidad,
            int n_camas, String tipo_cama, String wifi, String clave_acceso, int horaI_servicio, 
            int horaF_servicio) 
    {
        super(precio, numero_habitacion, disponibilidad, n_camas, tipo_cama, wifi, clave_acceso, 
                horaI_servicio, horaF_servicio);
        this.vista = vista;
        this.cuartos = cuartos;
        this.wifi_priv = wifi_priv;
        this.jacuzzi = jacuzzi;
        this.terraza = terraza;
        this.servicios_vip = servicios_vip;
    }

    public String getWifiPriv() 
    {
        return wifi_priv;
    }

    public void setWifiPriv(String wifi_priv) 
    {
        this.wifi_priv = wifi_priv;
    }
}
