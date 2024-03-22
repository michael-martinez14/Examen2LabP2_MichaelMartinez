/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2labp2_michaelmartinez;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Michael Martínez
 */
public class AdminCarros implements Serializable{
    private ArrayList <Carro> listaCarros=new ArrayList();
    private File archivo;

    public AdminCarros(String path) {
        archivo=new File(path);
    }

    public ArrayList<Carro> getListaCarros() {
        return this.listaCarros;
    }

    public void setListaCarros(ArrayList<Carro> listaCarros) {
        this.listaCarros = this.listaCarros;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void leer() {
        try {
            listaCarros = new ArrayList();
            Carro temporal = null;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temporal = (Carro) objeto.readObject()) != null) {
                        listaCarros.add(temporal);
                    }
                } catch (IOException e ) {
                }
                entrada.close();
                objeto.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void escribir() throws FileNotFoundException, IOException{
        FileOutputStream fw=new FileOutputStream(archivo);
        ObjectOutputStream bw=new ObjectOutputStream(fw);
        try {
            for (Carro c : listaCarros) {
                bw.writeObject(c);
            }
            bw.flush();
            bw.close();
            fw.close();
            
        } catch (Exception e) {
        }
    }
}
