/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
/**
 *
 * @author Grupo 4
 */
public class Proveedores {
   
       private int id_Proveedores;
    private String proveedor,nit, direccion,telefono;
    private Conexion cn;
    
    public Proveedores(){}    
    public Proveedores(int id_Proveedores, String proveedor, String nit, String direccion, String telefono) {
        this.id_Proveedores = id_Proveedores;
        this.proveedor = proveedor;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
    }


     public int getId_Proveedores() {
        return id_Proveedores;
    }

    public void setId_Proveedores(int id_Proveedores) {
        this.id_Proveedores = id_Proveedores;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

        public HashMap drop_sangre(){
       HashMap<String,String> drop = new HashMap();
        
        try{
            String query ="SELECT id_Proveedores as idProveedor,proveedor,nit,direccion,telefono from proveedores;";
       cn= new Conexion();
        cn.abrir_conexion();
       ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
       while(consulta.next()){
        drop.put(consulta.getString("idProveedor"),consulta.getNString("proveedor"), consulta.getNString("nit"), consulta.getNString("direccion"), consulta.getNString("telefono"));
       
       }
        cn.cerrar_conexion();
        }catch(SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        
        
        
        return drop;
    }
}