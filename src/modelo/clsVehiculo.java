package modelo;

/**
 *
 * @author AdrianM
 */


//CLASE ABSTRACTA
public abstract class clsVehiculo {
    //ATRIBUTOS
    private String propietario;
    private long runt;
    
    //METODOS
    public clsVehiculo(){}
    public clsVehiculo(String propietario, long runt) {
        this.propietario = propietario;
        this.runt = runt;
    }
    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public long getRunt() {
        return runt;
    }
    public void setRunt(long runt) {
        this.runt = runt;
    }
    //Metodo abstracto polimorfico
    public abstract String obtenerInformacion();
}
