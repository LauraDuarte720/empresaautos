package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo implements ICosto{
    private int cantidadPuertas;

    public Auto(String matricula, String marca, String modelo, int anoFabricacion, int cantidadPuertas, Reserva reserva) {
        super(matricula, marca, modelo, anoFabricacion, reserva);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    //metodo del costo del auto
    @Override
    public double calcularCosto(){
        double tarifaBase=40000;
        int dias=reserva.getDias();
        double total=tarifaBase*dias;
        return total;
        
    }

    @Override
    public String toString(){
        return "\nAuto: "+super.toString()+ "cantidad de puertas= "+cantidadPuertas+"\n";  
    }
    
}
