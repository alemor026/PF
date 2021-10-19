/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author olive
 */
public class Producto extends Productos{
    private int idMarca;
public Producto(){}
Conexion cn;
    public Producto(int idMarca) {
        this.idMarca = idMarca;
    }

    public Producto(int idMarca, int id, int existencia, String producto, String descripcion, String precio_costo, String precio_venta, String imagen, String fecha_ingreso) {
        super(id, existencia, producto, descripcion, precio_costo, precio_venta, imagen, fecha_ingreso);
        this.idMarca = idMarca;
    }
    
     public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
   

   
     public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            
            cn=new Conexion();
            String query="SELECT e.idProducto as id,e.producto,p.marca,e.idMarca,e.descripcion,e.imagen,e.precio_costo,e.precio_venta,e.existencia,e.fecha_ingreso From productos as e inner join marcas as p on p.idMarca=e.idMarca;";
            cn.abrir_conexion();
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","producto","idMarca","marca","descripcion","imagen","precio_costo","precio_venta","existencia","fecha_ingreso"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] =new String[10];
            while (consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("producto");
            datos[2] = consulta.getString("Marca");
            datos[3] = consulta.getString("descripcion");
            datos[4] = consulta.getString("imagen");
            datos[5] = consulta.getString("precio_costo");
            datos[6] = consulta.getString("precio_venta");
            datos[7] = consulta.getString("existencia");
            datos[8] = consulta.getString("fecha_ingreso");
             datos[9] = consulta.getString("idMarca");

            tabla.addRow(datos);
            
            }
            
            cn.cerrar_conexion();
        }catch(Exception ex){
            
            System.out.print("Error....."+ ex.getMessage());
            
        }
        return tabla;
    }
    @Override
    public int agregar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="INSERT INTO productos(producto,idMarca,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso)VALUES(?,?,?,?,?,?,?,?);";
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getProducto());
            parametro.setInt(2, getIdMarca());
              parametro.setString(3, getDescripcion());
              parametro.setString(4, getImagen());
                parametro.setString(5, getPrecio_costo());
                  parametro.setString(6, getPrecio_venta());
                    parametro.setInt(7, getExistencia());
                    parametro.setString(8, getFecha_ingreso());
                      
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
            return 0;
        }
       
    
        
        return retorno;
    }


    @Override
 public int modificar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="UPDATE productos SET producto =?,idMarca =?,descripcion =?,imagen =?,precio_costo =?,precio_venta =?,existencia =?,fecha_ingreso=? WHERE idProducto =?;";
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getProducto());
            parametro.setInt(2, getIdMarca());
              parametro.setString(3, getDescripcion());
              parametro.setString(4, getImagen());
                parametro.setString(5, getPrecio_costo());
                  parametro.setString(6, getPrecio_venta());
                    parametro.setInt(7, getExistencia());
                    parametro.setString(8, getFecha_ingreso());
                    parametro.setInt(9, getId());
                      
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
           
        }
       
    
        
        return retorno;
    }
    @Override
    public int eliminar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="Delete from  productos WHERE idProducto=?;";
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
           
                    parametro.setInt(1, getId());
                      
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
           
        }
       
    
        
        return retorno;
    }
    
   
}
