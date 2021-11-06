package modelo;
import modelo.enumMoto;

/**
 *
 * @author AdrianM
 */
//CONCEPTO DE HERENCIA E INTERFACE
public class clsMoto extends clsVehiculo implements iGestion{
    //ATRIBUTOS
    private int cilindraje;
    private enumMoto tipo;
    //METODOS
    public clsMoto(){}
    public clsMoto(String propietario, long runt, 
            int cilindraje, enumMoto tipo) {
        super(propietario,runt); //llamado al constructor padre
        this.cilindraje = cilindraje;
        this.tipo = tipo;
    }
    public int getCilindraje() {
        return cilindraje;
    }
    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    public enumMoto getTipo() {
        return tipo;
    }
    public void setTipo(enumMoto tipo) {
        this.tipo = tipo;
    }
    //Metodo polimorfico heredado de la herencia clsVehiculo
    @Override
    public String obtenerInformacion() {
        String info = 
                "==========INFO MOTO========"+"\n"+
                "Propietario: " +super.getPropietario()+"\n"+
                "Runt: "+super.getRunt()+"\n"+
                "Cilindraje: "+this.cilindraje+"\n"+
                "Tipo: "+this.tipo+"\n"+
                "Impuesto a pagar:"+calcularImpuesto()+"\n";
        return info;
    }
    
    public String obtenerFormatoArchivo() {
        String info = 
                super.getPropietario()+"\n"+
                super.getRunt()+"\n"+
                this.cilindraje+"\n"+
                this.tipo+"\n"+
                this.calcularImpuesto();
        return info;
    }
    
    //Metodo polimorfico implementado de la interface iGestion
    @Override
    public double calcularImpuesto() {
        double resultado=0;
        if(this.tipo == enumMoto.Clasica){
            resultado = 50000*IVA;
        }
        else{
            if(this.tipo == enumMoto.Deportiva){
                resultado = 10000*IVA;
            }
            else{
                if(this.tipo == enumMoto.CicloMotores){
                    resultado = 150000*IVA;
                }
                else{
                    if(this.tipo == enumMoto.Scooter){
                        resultado = 200000*IVA;
                    }
                    else{
                        resultado = 250000*IVA;
                    }
                }
            }
        }
        return resultado;
    }
    
    
}
