/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author olive
 */
abstract class Persona {
    private String nombres,apellidos,nit,genero,telefono,correo_electronico,fecha_ingreso;
 public Persona(){}
    public Persona(String nombres, String apellidos, String nit, String genero, String telefono, String correo_electronico, String fecha_ingreso) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nit = nit;
        this.genero = genero;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.fecha_ingreso = fecha_ingreso;
    }
    

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
     public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
    
    
}
