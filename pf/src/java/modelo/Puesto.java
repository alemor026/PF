/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo 4
 */
public class Puesto {
    private String puesto,id;
    public Puesto(){}
    public Puesto(String puesto, String id) {
        this.puesto = puesto;
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
      private Conexion cn;
            public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            
            cn=new Conexion();
            String query="SELECT idPuesto as id,puesto FROM puestos;";
            cn.abrir_conexion();
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","puesto"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] =new String[3];
            while (consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("puesto");
           
            tabla.addRow(datos);
            
            }
            
            cn.cerrar_conexion();
        }catch(Exception ex){
            
            System.out.print("Error....."+ ex.getMessage());
            
        }
        return tabla;
    }
            
            public int Agregar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="INSERT INTO puestos (puesto)VALUES(?);"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getPuesto());
            
                  
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }
            
                    public int Modificar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="UPDATE puestos SET puesto=? WHERE idPuesto=?;"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getPuesto());
             parametro.setString(2, getId());
            
                  
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }

  public int Eliminar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="Delete From puestos WHERE idPuesto=?;"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);

             parametro.setString(1, getId());
            
                  
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }

    
    
    
    
}
