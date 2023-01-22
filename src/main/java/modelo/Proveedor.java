/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Proveedor {
     private String cedulaORUC, nombre, direccion, telefono;

    public Proveedor(String cedulaORUC, String nombre, String direccion, String telefono) {
        this.cedulaORUC = cedulaORUC;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCedulaORUC() {
        return cedulaORUC;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
     
}
