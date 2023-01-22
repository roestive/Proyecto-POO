/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Admin extends Usuario {

    public Admin(String usuario, String clave, String nombre) {
        super(usuario, clave, nombre);
    }

    public Admin(String usuario, String clave) {
        super(usuario, clave);
    }

    /*public void administarClientes(int opcion, String cedulaORUC, String nombre, String direccion, String telefono, TipoCliente tipoCliente){
        //Haces la logica
        try{
            switch(opcion){
            case 1:               
                break;
            case 2:
                //Haz otra cosa
                break;
            default:
                System.out.print("Se ingreso mal la opcion");
                break;
            }
        }catch(){
        }
        
    }*/
    public void agregarCliente(String cedulaORUC, String nombre, String direccion, String telefono, TipoCliente tipoCliente, String ruta) {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) lector.readObject();
            Cliente cliente = new Cliente(cedulaORUC, nombre, direccion, telefono, tipoCliente);
            clientes.add(cliente);
            lector.close();
            File archivo = new File(ruta);
            archivo.delete();
            FileOutputStream fl = new FileOutputStream(ruta);
            ObjectOutputStream escritor = new ObjectOutputStream(fl);
            escritor.writeObject(clientes);
            fl.close();
        } catch (EOFException err) {
            try {
                ArrayList<Cliente> clientes = new ArrayList<>();
                Cliente cliente = new Cliente(cedulaORUC, nombre, direccion, telefono, tipoCliente);
                clientes.add(cliente);
                FileOutputStream fl = new FileOutputStream(ruta);
                ObjectOutputStream escritor = new ObjectOutputStream(fl);
                escritor.writeObject(clientes);
                fl.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void editarCliente(String cedulaORUC, String nombre, String direccion, String telefono, TipoCliente tipoCliente, String ruta) {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) lector.readObject();
            Cliente clienteBuscar = new Cliente(cedulaORUC, nombre, direccion, telefono, tipoCliente);
            for (Cliente cliente : clientes) {
                if (clienteBuscar.getCedulaORUC().equals(cliente.getCedulaORUC())) {
                    clientes.remove(cliente);
                }
            }
            clientes.add(clienteBuscar);
            lector.close();
            File archivo = new File(ruta);
            archivo.delete();
            FileOutputStream fl = new FileOutputStream(ruta);
            ObjectOutputStream escritor = new ObjectOutputStream(fl);
            escritor.writeObject(clientes);
            fl.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public String eliminarCliente(String cedulaORUC) {
        return cedulaORUC;
    }

    public void agregarProveedor(String cedulaORUC, String nombre, String direccion, String telefono, String ruta) {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Proveedor> proveedores = (ArrayList<Proveedor>) lector.readObject();
            Proveedor proveedor = new Proveedor(cedulaORUC, nombre, direccion, telefono);
            proveedores.add(proveedor);
            lector.close();
            File archivo = new File(ruta);
            archivo.delete();
            FileOutputStream fl = new FileOutputStream(ruta);
            ObjectOutputStream escritor = new ObjectOutputStream(fl);
            escritor.writeObject(proveedores);
            fl.close();
        } catch (EOFException err) {
            try {
                ArrayList<Proveedor> proveedores = new ArrayList<>();
                Proveedor proveedor = new Proveedor(cedulaORUC, nombre, direccion, telefono);
                proveedores.add(proveedor);
                FileOutputStream fl = new FileOutputStream(ruta);
                ObjectOutputStream escritor = new ObjectOutputStream(fl);
                escritor.writeObject(proveedores);
                fl.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void editarProveedor(String cedulaORUC, String nombre, String direccion, String telefono, String ruta) {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Proveedor> proveedores = (ArrayList<Proveedor>) lector.readObject();
            Proveedor proveedorBuscar = new Proveedor(cedulaORUC, nombre, direccion, telefono);
            for (Proveedor proveedor : proveedores) {
                if (proveedorBuscar.getCedulaORUC().equals(proveedor.getCedulaORUC())) {
                    proveedores.remove(proveedor);
                }
            }
            proveedores.add(proveedorBuscar);
            lector.close();
            File archivo = new File(ruta);
            archivo.delete();
            FileOutputStream fl = new FileOutputStream(ruta);
            ObjectOutputStream escritor = new ObjectOutputStream(fl);
            escritor.writeObject(proveedores);
            fl.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public String eliminarProveedor(String cedulaORUC) {
        return cedulaORUC;
    }

    public void agregarServicio(String nombre, double precio, String ruta) {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Servicio> servicios = (ArrayList<Servicio>) lector.readObject();
            Servicio servicio = new Servicio(nombre, Servicio.generarCodigo(), precio);
            servicios.add(servicio);
            lector.close();
            File archivo = new File(ruta);
            archivo.delete();
            FileOutputStream fl = new FileOutputStream(ruta);
            ObjectOutputStream escritor = new ObjectOutputStream(fl);
            escritor.writeObject(servicios);
            fl.close();
        } catch (EOFException err) {
            try {
                ArrayList<Servicio> servicios = new ArrayList<>();
                Servicio servicio = new Servicio(nombre, Servicio.generarCodigo(), precio);
                servicios.add(servicio);
                FileOutputStream fl = new FileOutputStream(ruta);
                ObjectOutputStream escritor = new ObjectOutputStream(fl);
                escritor.writeObject(servicios);
                fl.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void editarServicio(String nombre, double precio, String ruta) {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Servicio> servicios = (ArrayList<Servicio>) lector.readObject();
            Servicio servicioBuscar = new Servicio(nombre, Servicio.generarCodigo(), precio);
            for (Servicio servicio : servicios) {
                if (servicioBuscar.getCodigo() == servicio.getCodigo()) {
                    servicios.remove(servicio);
                }
            }
            servicios.add(servicioBuscar);
            lector.close();
            File archivo = new File(ruta);
            archivo.delete();
            FileOutputStream fl = new FileOutputStream(ruta);
            ObjectOutputStream escritor = new ObjectOutputStream(fl);
            escritor.writeObject(servicios);
            fl.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
    
    public boolean equals(Admin admin){
    if(admin.usuario.equals(this.usuario) && admin.clave.equals(this.clave))
        return true;
    return false;         
    }

    public int eliminarServicio(int codigo) {
        return codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

}
