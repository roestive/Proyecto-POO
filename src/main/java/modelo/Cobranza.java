/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Cobranza extends Usuario {

    public Cobranza(String usuario, String clave, String nombre) {
        super(usuario, clave, nombre);
    }

    public Cobranza(String usuario, String clave) {
        super(usuario, clave);
    }

    public ArrayList<Orden> generarFacturaEmpresarial(int codigo, String mes, String ruta) {
        ArrayList<Orden> ordenesMes = new ArrayList<>();
        for (Orden orden : Tecnico.cargarOrdenes(ruta)) {
            if (codigo == orden.getCodigo()) {
                String mesComparar = orden.getFecha().split("/")[1];
                if (mesComparar.equals(mes)) {
                    ordenesMes.add(orden);
                }
            }
        }
        return ordenesMes;
    }

    public ArrayList<Servicio> reporteIngresoServicio(String mes, String ruta) {
        ArrayList<Servicio> servicios = new ArrayList<>();
        for (Orden orden : Tecnico.cargarOrdenes(ruta)) {
            for (Servicio servicio : orden.getServicios()) {
                String mesComparar = orden.getFecha().split("/")[1];
                if (mesComparar.equals(mes)) {
                    servicios.add(servicio);
                }
            }
        }
        return servicios;
    }

    public ArrayList<Tecnico> reporteAtencionesTecnico(String mes, ArrayList<Tecnico> tecnicos) {
        ArrayList<Tecnico> tecnicosRecaudacion = new ArrayList<>();
        for (Tecnico tecnico : tecnicos) {
            ArrayList<Orden> ordenes = new ArrayList<>();
            for (Orden orden : tecnico.getOrdenes()) {
                String mesComparar = orden.getFecha().split("/")[1];
                if (mesComparar.equals(mes)) {
                    ordenes.add(orden);
                }
            }
            Tecnico tecnicoReporte = new Tecnico(tecnico.getNombre(), ordenes);
            tecnicosRecaudacion.add(tecnicoReporte);
        }
        return tecnicosRecaudacion;
    }
    
        public boolean equals(Cobranza cobranza){
    if(cobranza.usuario.equals(this.usuario) && cobranza.clave.equals(this.clave))
        return true;
    return false;         
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
    
}
