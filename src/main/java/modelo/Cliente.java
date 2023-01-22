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
public class Cliente {
    private String cedulaORUC, nombre, direccion, telefono;
    private TipoCliente tipoCliente;

    public Cliente(String cedulaORUC, String nombre, String direccion, String telefono, TipoCliente tipoCliente) {
        this.cedulaORUC = cedulaORUC;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
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

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
    
}
