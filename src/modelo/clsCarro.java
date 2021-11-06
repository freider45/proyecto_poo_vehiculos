package modelo;

/**
 *
 * @author AdrianM
 */

//CONCEPTO DE HERENCIA E INTERFACE
public class clsCarro extends clsVehiculo implements iGestion{
    //ATRIBUTOS
    private int puertas;
    private String matricula;
    private double impuesto;
    //METODOS
    public clsCarro(){}
    public clsCarro(String propietario, long runt, 
            int puertas, String matricula,double impuesto) {
        super(propietario,runt); //llamado al constructor padre
        this.puertas = puertas;
        this.matricula = matricula;
        this.impuesto = impuesto;
    }
    public int getPuertas() {
        return puertas;
    }
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
    

    //Metodo polimorfico heredado de la herencia clsVehiculo
    @Override
    public String obtenerInformacion() {
        String info = 
                "========INFO CARRO======"+"\n"+
                "Propietario: " +super.getPropietario()+"\n"+
                "Runt: "+super.getRunt()+"\n"+
                "Puertas: "+this.puertas+"\n"+
                "matricula: "+this.matricula+"\n"+
                "Impuesto a pagar:"+calcularImpuesto()+"\n";
        return info;
    }
    
    public String obtenerFormatoArchivo() {
        String info = 
                super.getPropietario()+","+
                super.getRunt()+","+
                this.puertas+","+
                this.matricula+","+
                this.calcularImpuesto()+"\n";
        return info;
    }
    
    //Metodo polimorfico implementado de la interface iGestion
    @Override
    public double calcularImpuesto() {
        double resultado=0;
        
        switch(this.puertas){
            case 2:
                resultado = 2*100000*IVA;
                break;
            case 3:
                resultado = 3*100000*IVA;
                break;
            case 4:
                resultado = 4*100000*IVA;
                break;
            case 5:
                resultado = 5*100000*IVA;
                break;
            default:
                resultado = -1;                
        }
        return resultado;
    }

}
