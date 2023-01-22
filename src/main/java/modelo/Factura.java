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
public class Factura {
    private String codigo;
    private int anio, mes;

    public Factura(String codigo, int anio, int mes) {
        this.codigo = codigo;
        this.anio = anio;
        this.mes = mes;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }
    
}
