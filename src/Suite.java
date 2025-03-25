



public class Suite extends Habitaciones implements complemento {

    float precioS; 
    

    public Suite(String nombre,int nHabitacion, String tipo_H, String tamaño, float precio,int extra,int noche) {
        super(nombre,nHabitacion, tipo_H, tamaño, precio, extra,noche);
    }

 
    @Override
    public void Eleccion() 
    {
       switch(tipo_H)
       {
        default -> {
            }
       }
       
    }
    
    
    void precS(){
        precio = 8000;
    }
  
    @Override
    public void calculo()
    {
        precioS = precio +(extra*100);
        System.out.println("el precio final es " + precioS);
    }

    @Override
    public void tamañoE() 
    {
        System.out.println("El tamaño de la Suite es: " + tamaño);
        System.out.println("actualmente contamos con las siguientes habitaciones:");
        System.out.println("chica: 2 personas");
        System.out.println("mediana:4 personas");
        System.out.println("grande: 6 personas");
        System.out.println("el tamaño de habitacion elejido es " + tamaño);
    }

   
    @Override
    public void noches() {
        System.out.println("La cantidad de noches resrvadas son " + noche);

    }

   // @Override
    //public void check_out(){

    

    
    void inf_S() {
        System.out.println("--------------------");
        System.out.println(" Suite ");
        System.out.println("Precio base por noche: $" + precioS);
        System.out.println(" Beneficios exclusivos:");
        System.out.println(" Habitacion amplia con vista panoramica");
        System.out.println(" Camas mas Grande");
        System.out.println(" Wifi exclusivo");
        System.out.println(" Servicio de atencion privada");
        System.out.println(" Alimentos y bebidas incluidos");
        System.out.println("--------------------");
    }
}
