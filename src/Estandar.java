


public class Estandar extends Habitaciones implements complemento{
    float precioF;
    
    //String capacidad;

    public Estandar(String nombre,int nHabitacion, String tipo_H,String tamaño,float precio,int extra,int noche) {
            super(nombre,nHabitacion, tipo_H,tamaño,precio,noche,extra);
            
            
            //this.capacidad = capacidad;
        
        
        
    }
    
    @Override
   public void Eleccion(){
   switch(tipo_H){
       
       
       
       
       case "Estandar" -> System.out.println("holaaaa mundo");
   }
   
   }
   
   void precE(){
        precio = 3600;
    }
   
   
   
    @Override
   public void calculo(){
       
       precioF = precio + (extra * 100);
        System.out.println("el precio final es " + precioF);
       
   }
   
    @Override
   public void noches(){
        System.out.println("usted reservo un total de: " + noche);
        precioF = precio;
        precioF = noche * precioF;
        System.out.println("el total a pagar es de: " + precioF);
       
   }
   
    @Override
   public void tamañoE(){
       
       
                System.out.println("actualmente contamos con las siguientes habitaciones:");
                System.out.println("chica: 2 personas");
                System.out.println("mediana:4 personas");
                System.out.println("grande: 6 personas");



       
   }

   //@Override
   //public void check_out(){
   //     System.out.println("Ingrese el numero de habitacion para realizar el check out para realizar");
   //}
   
   void inf_E(){
        
        System.out.println("--------------------");
        System.out.println("Estandar:"); 
        System.out.println("tiene un precio de " + precio + " por noche");
        
            System.out.println("");
        System.out.println("cuenta con los siguientes beneficios:");
        System.out.println("cama mediana");
        System.out.println("wifi");
        System.out.println("servicio atencion al cliente");
        System.out.println("--------------------");
        
    }


}