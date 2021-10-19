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
 * @author Grupo 4
 */
public class Producto extends Productos{
    private int id_Marcas;
     Conexion cn;
public Producto(){}
    public Producto(int id_Marcas) {
        this.id_Marcas = id_Marcas;
    }

    public Producto(int id_Marcas, int id, int existencia, String producto, String descripcion, String precio_costo, String precio_venta) {
        super(id, existencia, producto, descripcion, precio_costo, precio_venta);
        this.id_Marcas = id_Marcas;
    }

    public int getId_Marcas() {
        return id_Marcas;
    }

    public void setId_Marcas(int id_Marcas) {
        this.id_Marcas = id_Marcas;
    }
     public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            
            cn=new Conexion();
            String query="SELECT e.id_Productos as id,e.producto,p.Marca,e.id_Marcas,e.descripcion,e.precio_costo,e.precio_venta,e.existencia FROM productos as e inner join marcas as p on p.id_Marcas=e.id_Marcas;";
            cn.abrir_conexion();
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","producto","id_marcas","marca","descripcion","precio_costo","precio_venta","existencia"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] =new String[8];
            while (consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("producto");
            datos[2] = consulta.getString("Marca");
            datos[3] = consulta.getString("descripcion");
            datos[4] = consulta.getString("precio_costo");
            datos[5] = consulta.getString("precio_venta");
            datos[6] = consulta.getString("existencia");
             datos[7] = consulta.getString("id_Marcas");

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
            String query="INSERT INTO productos(producto,id_Marcas,descripcion,precio_costo,precio_venta,existencia)VALUES(?,?,?,?,?,?);";
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
            parametro.setString(1, getProducto());
            parametro.setInt(2, getId_Marcas());
              parametro.setString(3, getDescripcion());
                parametro.setString(4, getPrecio_costo());
                  parametro.setString(5, getPrecio_venta());
                    parametro.setInt(6, getExistencia());
                      
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }

    
   
}
