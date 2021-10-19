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
abstract class Productos {
    private int id;
    private int existencia;
    private String producto, descripcion,precio_costo,precio_venta;
    public Productos(){}
    public Productos(int id, int existencia, String producto, String descripcion, String precio_costo, String precio_venta) {
        this.id = id;
        this.existencia = existencia;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(String precio_costo) {
        this.precio_costo = precio_costo;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }
    public int agregar(){return 0;}
    public int modificar(){return 0;}
    public int eliminar(){return 0;}
}
