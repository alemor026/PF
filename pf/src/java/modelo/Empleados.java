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
public class Empleados extends Persona{
    private String idPuesto;
    private int id;
    
    Conexion cn;
    public Empleados(){}

    public Empleados(String idPuesto, int id) {
        this.idPuesto = idPuesto;
        this.id = id;
    }

    public Empleados(String idPuesto, int id, String nombres, String apellidos, String direccion, String telefono, String DPI, String genero, String fecha_nacimiento, String fecha_inicio_labores, String fecha_ingreso) {
        super(nombres, apellidos, direccion, telefono, DPI, genero, fecha_nacimiento, fecha_inicio_labores, fecha_ingreso);
        this.idPuesto = idPuesto;
        this.id = id;
    }
      public String getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(String idPuesto) {
        this.idPuesto = idPuesto;
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
            String query="SELECT e.idEmpleado as id,e.nombres,e.apellidos,e.direccion,e.telefono,e.DPI,e.genero,e.fecha_nacimiento,p.Puesto,e.idPuesto,e.fecha_inicio_labores,e.fecha_ingreso FROM empleados as e inner join puestos as p on e.idPuesto = p.idPuesto;";
            cn.abrir_conexion();
            ResultSet consulta=cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","nombres","apellidos","direccion","telefono","dpi","genero","nacimiento","puesto","fecha_inicio_labores","fecha_ingreso"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] =new String[12];
            while (consulta.next()){
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("nombres");
            datos[2] = consulta.getString("apellidos");
            datos[3] = consulta.getString("direccion");
            datos[4] = consulta.getString("telefono");
             datos[5] = consulta.getString("DPI");
              datos[6] = consulta.getString("genero");
            datos[7] = consulta.getString("fecha_nacimiento");
            
            datos[8] = consulta.getString("puesto");
            datos[9] = consulta.getString("fecha_inicio_labores");
            datos[10] = consulta.getString("fecha_ingreso");
            datos[11] = consulta.getString("idPuesto");
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
            String query="INSERT INTO empleados(nombres,apellidos,direccion,telefono,DPI,genero,fecha_nacimiento,idPuesto,fecha_inicio_labores,fecha_ingreso)VALUES(?,?,?,?,?,?,?,?,?,?);"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
          
            parametro.setString(1, getNombres());
              parametro.setString(2, getApellidos());
                parametro.setString(3, getDireccion());
                  parametro.setString(4, getTelefono());
                    parametro.setString(5, getDPI());
                    parametro.setString(6, getGenero());
                    parametro.setString(7, getFecha_nacimiento());
                     parametro.setString(8, getIdPuesto());
                      parametro.setString(9, getFecha_inicio_labores());
                         parametro.setString(10, getFecha_ingreso()); 
                     
                    retorno =parametro.executeUpdate();
                  cn.cerrar_conexion();
             
                  
            //JOptionPane.showMessageDialog(null, Integer.toHexString(executar)+ "Reegistro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
            
            System.out.print("Error....."+ ex.getMessage());
        }
       
    
        
        return retorno;
    }

    @Override
 public int Modificar(){
        int retorno=0;
        
         try{
            PreparedStatement parametro;
            String query="UPDATE  empleados SET nombres=?,apellidos=?,direccion=?,telefono=?,DPI=?,genero=?,fecha_nacimiento=?,idPuesto=?,fecha_inicio_labores=?,fecha_ingreso=? WHERE idEmpleado=?;"; 
            cn = new Conexion();
            cn.abrir_conexion();
            parametro =(PreparedStatement) cn.conexionBD.prepareCall(query);
          
            parametro.setString(1, getNombres());
              parametro.setString(2, getApellidos());
                parametro.setString(3, getDireccion());
                  parametro.setString(4, getTelefono());
                    parametro.setString(5, getDPI());
                    parametro.setString(6, getGenero());
                    parametro.setString(7, getFecha_nacimiento());
                     parametro.setString(8, getIdPuesto());
                      parametro.setString(9, getFecha_inicio_labores());
                         parametro.setString(10, getFecha_ingreso()); 
                         parametro.setInt(11, getId()); 
                         
                     
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
            String query="DELETE FROM  empleados WHERE idEmpleado=?;"; 
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

