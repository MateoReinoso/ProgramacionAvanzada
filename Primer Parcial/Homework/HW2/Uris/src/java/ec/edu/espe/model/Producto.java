/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author Mateo
 */
public class Producto {
    private String codigoprod;
    private String nombreprod;
    private String descripcion;
    private String peso;
    private String sensibilidad;
    private String valorubit;

    public Producto() {
    }

    public Producto(String codigoprod, String nombreprod, String descripcion, String peso, String sensibilidad, String valorubit) {
        this.codigoprod = codigoprod;
        this.nombreprod = nombreprod;
        this.descripcion = descripcion;
        this.peso = peso;
        this.sensibilidad = sensibilidad;
        this.valorubit = valorubit;
    }

    public String getCodigoprod() {
        return codigoprod;
    }

    public void setCodigoprod(String codigoprod) {
        this.codigoprod = codigoprod;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getSensibilidad() {
        return sensibilidad;
    }

    public void setSensibilidad(String sensibilidad) {
        this.sensibilidad = sensibilidad;
    }

    public String getValorubit() {
        return valorubit;
    }

    public void setValorubit(String valorubit) {
        this.valorubit = valorubit;
    }
        
}
