/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Tecnico extends Usuario {

    ArrayList<Orden> ordenes;

    public Tecnico(String usuario, String clave, String nombre, ArrayList<Orden> ordenes) {
        super(usuario, clave, nombre);
       this.ordenes = ordenes;
    }
    
    public Tecnico(String nombre, ArrayList<Orden> ordenes){
    super(nombre);
    this.ordenes = ordenes;
    }
    
    public Tecnico(String usuario, String clave) {
        super(usuario, clave);
    }

    public static ArrayList<Orden> cargarOrdenes(String ruta) {
        ArrayList<Orden> ordenes = null;
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ordenes = (ArrayList<Orden>) lector.readObject();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return ordenes;
    }

    public double generarOrdenServicio(int codigo, String fecha, TipoVehiculo tipovehiculo, String placa, ArrayList<Servicio> servicios, Cliente cliente, String ruta) {
        Orden orden = null;
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Orden> ordenes = (ArrayList<Orden>) lector.readObject();
            orden = new Orden(fecha, codigo, placa, servicios, cliente);
            ordenes.add(orden);
            lector.close();
            File archivo = new File(ruta);
            archivo.delete();
            FileOutputStream fl = new FileOutputStream(ruta);
            ObjectOutputStream escritor = new ObjectOutputStream(fl);
            escritor.writeObject(ordenes);
            fl.close();
        } catch (EOFException err) {
            try {
                ArrayList<Orden> ordenes = new ArrayList<>();
                orden = new Orden(fecha, codigo, placa, servicios, cliente);
                ordenes.add(orden);
                FileOutputStream fl = new FileOutputStream(ruta);
                ObjectOutputStream escritor = new ObjectOutputStream(fl);
                escritor.writeObject(ordenes);
                fl.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        double calculo = 0;
        for (Servicio servicio : orden.getServicios()) {
            calculo += servicio.getPrecio();
        }
        return calculo;
    }
    
        public boolean equals(Tecnico tecnico){
    if(tecnico.usuario.equals(this.usuario) && tecnico.clave.equals(this.clave))
        return true;
    return false;         
    }

    public String reportarFaltaInzumo(String mensaje) {
        return mensaje;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
    
}
