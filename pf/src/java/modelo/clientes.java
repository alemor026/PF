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
public class clientes extends Persona {
    private String nit, correo_electronico;
    private int id;
    Conexion cn;
        public String getNit() {
        return nit;
    }

        
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
public clientes(){}
 public clientes(int id) {
        this.id = id;
    }

    public clientes(int id, String nombres, String apellidos, String nit, String genero, String telefono, String correo_electronico, String fecha_ingreso) {
        super(nombres, apellidos,genero, telefono, fecha_ingreso);
        this.nit = nit;
        this.correo_electronico = correo_electronico;
        this.id = id;
    }
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
   
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            
            cn=new Conexion();
            String query="SELECT idCliente as id,nombres,apellidos,nit,genero,telefono,correo_electronico,fecha_ingreso FROM clientes;";
            cn.abrir_conexion();
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","nombres","apellidos","nit","genero","telefono","correo_electronico","fecha_ingreso"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] =new String[8];
            while (consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("nombres");
            datos[2] = consulta.getString("apellidos");
            datos[3] = consulta.getString("nit");
             datos[4] = consulta.getString("genero");
            datos[5] = consulta.getString("telefono");
             datos[6] = consulta.getString("correo_electronico");
            datos[7] = consulta.getString("fecha_ingreso");
            tabla.addRow(datos);
            
            }
            
            cn.cerrar_conexion();
        }catch(Exception ex){
            
            System.out.print("Error....."+ ex.getMessage());
            
        }
        return tabla;
    }
     public int agregar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="INSERT INTO clientes (nombres,apellidos,nit,genero,telefono,correo_electronico,fecha_ingreso)VALUES(?,?,?,?,?,?,?);"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getNombres());
            parametro.setString(2, getApellidos());
            parametro.setString(3, getNit());
            parametro.setString(4, getGenero());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getCorreo_electronico());
            parametro.setString(7, getFecha_ingreso());
                  
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }

 public int modificar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="UPDATE clientes SET nombres = ?,apellidos = ?,nit = ?,genero = ?,telefono = ?,correo_electronico = ?,fecha_ingreso = ? WHERE idCliente =?; "; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getNombres());
            parametro.setString(2, getApellidos());
            parametro.setString(3, getNit());
            parametro.setString(4, getGenero());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getCorreo_electronico());
            parametro.setString(7, getFecha_ingreso());
            parametro.setInt(8, this.getId());
                  
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }
    
    public int eliminar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="delete from clientes  WHERE idCliente=?;"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
           
                    parametro.setInt(1, this.getId());
                  
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }


  
   

   
}
