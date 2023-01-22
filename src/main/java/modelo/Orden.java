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
public class Orden {
    private String fecha, placa;
    private int codigo;
    private ArrayList<Servicio> servicios;
    private Cliente cliente;

    public Orden(String fecha, int codigo, String placa, ArrayList<Servicio> servicios, Cliente cliente) {
        this.fecha = fecha;
        this.placa = placa;
        this.servicios = servicios;
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    
}
