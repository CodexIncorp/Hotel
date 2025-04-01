import java.util.ArrayList;

public class Habitaciones{
   
    int i;
    
    String nombre;
    String tipo_H;
    int extra;
    int noche;
    float precio;
    String tamaño;
    int nHabitacion;
    @SuppressWarnings("unused")
    Boolean disponibilidad;
    @SuppressWarnings("unused") //para que nos quite lo de que no esta usado
    int n_camas;
    @SuppressWarnings("unused")
    String tipo_cama;
    @SuppressWarnings("unused")
    String wifi;
    private String clave_acceso;
    @SuppressWarnings("unused")
    int horaI_servicio;
    @SuppressWarnings("unused")
    int horaF_servicio;

    public Habitaciones(String nombre,int nHabitacion, String tipo_H,String tamaño, float precio, int noches, int extra) 
    {
        this.nombre = nombre;
        this.nHabitacion = nHabitacion; 
        this.precio = precio;
        this.tipo_H = tipo_H;
        this.noche = noches;
        this.extra = extra;
        this.tamaño = tamaño;
    }
    
    public void reservar()
    {
        System.out.println("holaa pelooon" + tipo_H);
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
    
   
     public void MostrarE(ArrayList<Estandar>ticket){
        
        for(i=0; i<ticket.size(); i++ ){
            
            System.out.println("Reserva " + (i+1));
            System.out.println("");
            System.out.println("la habitacion queda reservada a nombre de: " + ticket.get(i).nombre);
            System.out.println("el numero de habitacion es: " + ticket.get(i).nHabitacion);
            System.out.println("el tipo de habitacion es: " + ticket.get(i).tipo_H);
            System.out.println("el tamaño de la habitacion es: " + ticket.get(i).tamaño);
            System.out.println("la cantidad de personas extra es: " + ticket.get(i).extra);
            System.out.println("la cantidad de noches reservadas es: " + ticket.get(i).noche);
            System.out.println("el precio total es: " + ticket.get(i).precio);
            
            
        }

        

    
}

 public void MostrarS(ArrayList<Suite>ticket1){
        
        for(i=0; i<ticket1.size(); i++ ){
            
            System.out.println("Reserva " + (i+1));
            System.out.println("");
            System.out.println("la habitacion queda reservada a nombre de: " + ticket1.get(i).nombre);
            System.out.println("el numero de habitacion es: " + ticket1.get(i).nHabitacion);
            System.out.println("el tipo de habitacion es: " + ticket1.get(i).tipo_H);
            System.out.println("el tamaño de la habitacion es: " + ticket1.get(i).tamaño);
            System.out.println("la cantidad de personas extra es: " + ticket1.get(i).extra);
            System.out.println("la cantidad de noches reservadas es: " + ticket1.get(i).noche);
            System.out.println("el precio total es: " + ticket1.get(i).precio);
            
            
        }

        

    
}




    
    
    
    
    
    
    
    
   
    
}


