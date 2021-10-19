/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author olive
 */
public class Conexion {
    public Connection conexionBD;
    private final String puerto="3306";
    private final String bd ="bd_proyecto";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s",puerto, bd);
    private final String usuario = "root";
    private final String contra = "umg$2019";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    public void abrir_conexion(){
 try{
        Class.forName(jdbc);
        conexionBD=DriverManager.getConnection(urlConexion,usuario,contra);
        //JOptionPane.showMessageDialog(null,"Conexion exitosa....","Exito",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            System.out.println("Error:"+ ex.getMessage());
        }
    }
public void cerrar_conexion(){
    try {
       conexionBD.close();
    }catch(SQLException ex){
    System.out.print("Error....."+ ex.getMessage());
    }
}
}
