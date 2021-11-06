
package datos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.clsCarro;
import modelo.clsMoto;
import modelo.enumMoto;

/**
 *
 * @author freid
 */
public class gestionArchivo {
    //Atributos
    FileInputStream archivoLectura;
    DataInputStream datosOrigen;
    FileOutputStream archivoEscritura;
    DataOutputStream datosDestino;
    
    String linea;
    String [] partes;
    
    //Metodos
    public gestionArchivo(){
    }
    
    public void escribirDatosVehiculo(ArrayList<clsCarro> lstCarros){
        try {   
            String ruta = System.getProperty("user.dir");
            String rutaCompleta = ruta + "/" + "vehiculos.txt";
            File file = new File(rutaCompleta);

            // Si el archivo no existe es creado
            if (!file.exists()){
                file.createNewFile();

            }

            this.archivoEscritura = new FileOutputStream(rutaCompleta);
            this.datosDestino = new DataOutputStream(archivoEscritura);

            clsCarro auxCarro;
            for(int i=0;i<lstCarros.size();i++){
                auxCarro = lstCarros.get(i);
                linea = auxCarro.obtenerFormatoArchivo();
                datosDestino.writeUTF(linea);

            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Archivo No Encontrado",
                    "Gestion Escritura",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error En la Escritura de Datos",
                    "Gestion Escritura",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                archivoEscritura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error en el cierre del Archivo",
                    "Gestion Escritura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void leerDatosVehiculo(ArrayList<clsCarro> lstCarros){
        boolean bandera = true;
        clsCarro auxCarro;
        try{
            String ruta = System.getProperty("user.dir");
            String rutaCompleta = ruta + "/" + "vehiculos.txt";
            File file = new File(rutaCompleta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            this.archivoLectura = new FileInputStream(rutaCompleta);
            this.datosOrigen = new DataInputStream(archivoLectura);

            while(bandera){
                linea = this.datosOrigen.readUTF();
                partes = linea.split(",");
                auxCarro = new clsCarro();
                auxCarro.setPropietario(partes[0]);
                auxCarro.setRunt(Long.parseLong(partes[1]));
                auxCarro.setPuertas(Integer.parseInt(partes[2]));
                auxCarro.setMatricula(partes[3]);
                auxCarro.setImpuesto(Double.parseDouble(partes[4]));
                lstCarros.add(auxCarro);
            }
        }
        catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, 
                    "Archivo No Encontrado",
                    "Gestion Lectura",
                    JOptionPane.ERROR_MESSAGE);
        } 
        catch(EOFException ex){
            JOptionPane.showMessageDialog(null, 
                    "Carga de Datos con Exito",
                    "Gestion Lectura",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error en la Lectura de Datos",
                    "Gestion Lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                this.archivoLectura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error en el Cierre del Archivo",
                    "Gestion Lectura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /*
    public void escribirDatosMoto(ArrayList<clsMoto> lstMotos){
        try {   
            String ruta = "/C:\\Users\\freid\\Documents\\NetBeansProjects\\LPOO_P8_VEHICULOS/motos.txt";
            File file = new File(ruta);
            
            // Si el archivo no existe es creado
            if (!file.exists()){
                file.createNewFile();

            }

            this.archivoEscritura = new FileOutputStream(ruta);
            this.datosDestino = new DataOutputStream(archivoEscritura);

            clsMoto auxMoto;
            for(int i=0;i<lstMotos.size();i++){
                auxMoto = lstMotos.get(i);
                linea = auxMoto.obtenerFormatoArchivo();
                datosDestino.writeUTF(linea);

            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Archivo No Encontrado",
                    "Gestion Escritura",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error En la Escritura de Datos",
                    "Gestion Escritura",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                archivoEscritura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error en el cierre del Archivo",
                    "Gestion Escritura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void leerDatosMoto(ArrayList<clsMoto> lstMotos){
        boolean bandera = true;
        clsMoto auxMoto;
        try{
            String ruta = "/C:\\Users\\freid\\Documents\\NetBeansProjects\\LPOO_P8_VEHICULOS/vehiculos.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            this.archivoLectura = new FileInputStream(ruta);
            this.datosOrigen = new DataInputStream(archivoLectura);

            while(bandera){
                linea = this.datosOrigen.readUTF();
                partes = linea.split(",");
                auxMoto = new clsMoto();
                auxMoto.setPropietario(partes[0]);
                auxMoto.setRunt(Long.parseLong(partes[1]));
                auxMoto.setCilindraje(Integer.parseInt(partes[2]));
                enumMoto tipo;
                if(partes[3].equalsIgnoreCase("clasica")){
                    tipo = enumMoto.Clasica;
                }
                else{
                    if(partes[3].equalsIgnoreCase("deportiva")){
                        tipo = enumMoto.Deportiva;
                    }
                    else{
                        if(partes[3].equalsIgnoreCase("ciclo motores")){
                            tipo = enumMoto.CicloMotores;
                        }
                        else{
                            if(partes[3].equalsIgnoreCase("scooter")){
                                tipo = enumMoto.Scooter;
                            }
                            else{
                               tipo = enumMoto.Trail;
                            }
                        }
                        
                    }
                }
                auxMoto.setTipo(tipo);
                auxMoto.calcularImpuesto();
                lstMotos.add(auxMoto);
            }
        }
        catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, 
                    "Archivo No Encontrado",
                    "Gestion Lectura",
                    JOptionPane.ERROR_MESSAGE);
        } 
        catch(EOFException ex){
            JOptionPane.showMessageDialog(null, 
                    "Carga de Datos con Exito",
                    "Gestion Lectura",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error en la Lectura de Datos",
                    "Gestion Lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                this.archivoLectura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error en el Cierre del Archivo",
                    "Gestion Lectura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    */
}
