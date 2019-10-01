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
public class Cliente {
    private String ci;
    private String ruc;
    private String nombre;
    private String dirreccion;
    private String telfconvencional;
    private String telfcelular;
    private String correo;

    public Cliente(String ci, String ruc, String nombre, String dirreccion, String telfconvencional, String telfcelular, String correo) {
        this.ci = ci;
        this.ruc = ruc;
        this.nombre = nombre;
        this.dirreccion = dirreccion;
        this.telfconvencional = telfconvencional;
        this.telfcelular = telfcelular;
        this.correo = correo;
    }

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getTelfconvencional() {
        return telfconvencional;
    }

    public void setTelfconvencional(String telfconvencional) {
        this.telfconvencional = telfconvencional;
    }

    public String getTelfcelular() {
        return telfcelular;
    }

    public void setTelfcelular(String telfcelular) {
        this.telfcelular = telfcelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
