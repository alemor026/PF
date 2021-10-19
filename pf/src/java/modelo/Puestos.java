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
public class Puestos {
    
    private String idPuesto, puesto;
private Conexion cn;
public Puestos(){}

    public Puestos(String idPuesto, String puesto) {
        this.idPuesto = idPuesto;
        this.puesto = puesto;
        
    }
     public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }

    public String getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(String idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public HashMap drop_sangre(){
        HashMap<String,String> drop = new HashMap();
        
        try{
            String query ="SELECT idPuesto as id,puesto from puestos;";
        cn=new Conexion();
        cn.abrir_conexion();
       ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
       while(consulta.next()){
       drop.put(consulta.getString("id"),consulta.getNString("puesto"));
       
       }
        cn.cerrar_conexion();
        }catch(SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        
        
        
        return drop;
    }

   
}
