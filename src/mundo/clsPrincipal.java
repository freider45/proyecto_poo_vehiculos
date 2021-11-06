package mundo;

import datos.gestionArchivo;
import java.util.ArrayList;
import modelo.*;
import vista.vtnPrincipal;

/**
 *
 * @author AdrianM
 */
public class clsPrincipal {
    
    private static ArrayList<clsCarro> lstCarros;
    private static ArrayList<clsMoto> lstMotos;

    public static void main(String[] args) {
        clsPrincipal.lstCarros = new ArrayList<clsCarro>();
        clsPrincipal.lstMotos = new ArrayList<clsMoto>();
        
        gestionArchivo GA = new gestionArchivo();
        GA.leerDatosVehiculo(lstCarros);
        
        vtnPrincipal vtn = new vtnPrincipal(lstCarros,lstMotos);
        vtn.setVisible(true);
        
        
        /*clsVehiculo objV = new clsVehiculo("Pepito Perez",10050742);
        imprimir("Propietario: "+objV.getPropietario());
        imprimir("Runt: "+objV.getRunt());
        
        clsCarro objC = new clsCarro("Maria Velez",10050888,4,"Popayán");
        imprimir("Propietario: "+objC.getPropietario());
        imprimir("Runt: "+objC.getRunt());
        imprimir("Puertas: "+objC.getPuertas());
        imprimir("MAtricula: "+objC.getMatricula());
        imprimir(objC.saludo());*/
    }
    public static void imprimir(String vTexto){
        System.out.println(vTexto);
    }
}
