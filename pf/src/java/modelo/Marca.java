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
 * @author olive
 */
public class Marca {
    private String marca,id;
public Marca(){}

    public Marca( String marca, String id) {
       
        this.marca = marca;
        this.id = id;
        this.cn = cn;
    }
      

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
     // public int Agregar(){return 0;}
       // public int Modificar(){return 0;}
         //   public int Eliminar(){return 0;}
            
            private Conexion cn;
            public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            
            cn=new Conexion();
            String query="SELECT idMarca as id,marca FROM marcas;";
            cn.abrir_conexion();
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","marcas"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] =new String[3];
            while (consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("marca");
           
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
            String query="INSERT INTO marcas (marca)VALUES(?);"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getMarca());
            
                  
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
            String query="UPDATE marcas SET marca=? WHERE idMarca=?;"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getMarca());
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
            String query="Delete From marcas WHERE idMarca=?;"; 
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
