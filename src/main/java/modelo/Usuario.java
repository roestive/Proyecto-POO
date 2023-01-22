/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Usuario {
    protected String usuario;
    protected String clave;
    
    protected String nombre;

    public Usuario(String usuario, String clave, String nombre) {
        this.usuario = usuario;
        this.clave = clave;
        
        this.nombre = nombre;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    public Usuario(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public static boolean verificarUsuario(String usuarioBuscar, String claveBuscar, ArrayList<Admin> listaAdmin, ArrayList<Tecnico> listaTecnicos, ArrayList<Cobranza> listaCobranza) {
        for (Admin admin : listaAdmin) {
            if (admin.getUsuario().equals(usuarioBuscar) && admin.getClave().equals(claveBuscar)) {
                return true;
            }
        }

        for (Tecnico tecnico : listaTecnicos) {
            if (tecnico.getUsuario().equals(usuarioBuscar) && tecnico.getClave().equals(claveBuscar)) {
                return true;
            }
        }

        for (Cobranza cobranza : listaCobranza) {
            if (cobranza.getUsuario().equals(usuarioBuscar) && cobranza.getClave().equals(claveBuscar)) {
                return true;
            }
        }
        return false;
    }
    
    public static void cargarListaUsuarios(ArrayList<Tecnico> listaTecnicos, ArrayList<Cobranza> listaCobranza, ArrayList<Admin> listaAdmin){
        listaTecnicos.add(new Tecnico("alopez", "al123456"));
        listaTecnicos.add(new Tecnico("mbarcos", "mb123456"));
        listaCobranza.add(new Cobranza("mccastro", "mc123456"));
        listaAdmin.add(new Admin("admin1", "12345678"));
    }
}
