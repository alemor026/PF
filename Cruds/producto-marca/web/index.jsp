<%-- 
    Document   : index
    Created on : 21/09/2021, 13:05:58
    Author     : olive
--%>
<%@page import="modelo.Marca" %>
<%@page import="modelo.Producto" %>
<%@page import="modelo.Conexion" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
   
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
 
    </head>
    <body>
        
        <h1>Formulario Productos</h1>
          <div class="container pt-5">
       <form action = "sr_Productos" method="post" class= "form-group">
            <label for="lbl_id" ><b>ID</b></label>
         <input type="text" name="txt_id" id="txt_id" class="form-control" value="0" readonly="">
           <label for="lbl_producto" ><b>Producto</b></label>
           <input type="text" name="txt_producto" id="txt_producto" class="form-control">
           <label for="lbl_marca" ><b>Marca</b></label>
           <select name="drop_marca" class="form-select" id="drop_marca">
                <% 
                Marca marcas = new Marca();
                HashMap<String,String> drop = marcas.drop_sangre();
                for(String i: drop.keySet()){
                    out.println("<option value = '"+ i +"'>"+ drop.get(i)+"</option>");
                }
                   
                %>
                </select>
             <label for="lbl_descripcion" ><b>Descripcion</b></label>
             <input name="txt_descripcion" id="txt_descripcion" class="form-control">
                <label for="lbl_imagen" ><b>Imagen</b></label>
             <input name="txt_imagen" id="txt_imagen" class="form-control">
             <label for="lbl_precio_costo" ><b>Precio_costo</b></label>
             <input type="text" name="txt_precio_costo" id="txt_precio_costo" class="form-control">
             <label for="lbl_precio_venta" ><b>Precio_venta</b></label>
             <input type="text" name="txt_precio_venta" id="txt_precio_venta" class="form-control">
             <label for="lbl_existencia" ><b>Existencia</b></label>
             <input type="text" name="txt_existencia" id="txt_existencia" class="form-control">
              <label for="lbl_fn"class="form-control" ><b>Ingreso</b></label>
             <input type="date" name="txt_fn" id="txt_fn" class="form-control" placeholder=" YYY-MM-DD">
          
            <br>
          <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
           <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success  btn-lg">Modificar</button>
           <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger  btn-lg "onclick ">Eliminar</button>

            </form>
                <br>
      
                <table class="table table-bordered">
                    
                   
    <thead>
      <tr>
        <th>Producto</th>
        <th>Marca</th>
        <th>Descripcion</th>
        <th>Imagen</th>
        <th>Precio_costo</th>
        <th>Precio_venta</th>
        <th>Existencia</th>
        <th>Fecha_ingreso</th>
    
       
      </tr>
    </thead>
    <tbody id="tbl_productos">
        <%
             Producto productos = new Producto();
             DefaultTableModel tabla= new DefaultTableModel();
             tabla = productos.leer();
             for(int t=0; t<tabla.getRowCount();t++){
                out.println("<tr data-id="+tabla.getValueAt(t, 0)+">");
                out.println("<td>"+ tabla.getValueAt(t, 1)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 2)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 3)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 4)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 5)+"</td>");
                out.println("<td>"+ tabla.getValueAt(t, 6)+"</td>");
                 out.println("<td>"+ tabla.getValueAt(t, 7)+"</td>");
                  out.println("<td>"+ tabla.getValueAt(t, 8)+"</td>");
               
               
                out.println("</tr>");
                 
             } 
        %>
       
    </tbody>
     </table>
                 </div>
        
        
            <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
            <script type="text/javascript">
            $('#tbl_productos').on('click','tr td',function(evt){
                var target,id,id_M,producto,descripcion,imagen,precio_costo,precio_venta,existencia,fecha_ingreso;
                target = $(event.target);
                id = target.parent().data('id');
                 id_M= target.parent().data('id_M');
                producto = target.parent("tr").find("td").eq(0).html();
                 descripcion = target.parent("tr").find("td").eq(1).html();
                  imagen = target.parent("tr").find("td").eq(2).html();
                   precio_costo = target.parent("tr").find("td").eq(3).html();
                    precio_venta = target.parent("tr").find("td").eq(4).html();
                     existencia= target.parent("tr").find("td").eq(5).html();
                       fecha_ingreso = target.parent("tr").find("td").eq(6).html();
                         
                
 $("#txt_id").val(id);
                $("#txt_producto").val(producto);
                 $("#txt_descripcion").val(descripcion);
                  $("#txt_imagen").val(imagen);
                   $("#txt_precio_costo").val(precio_costo);
                    $("#txt_precio_venta").val(precio_venta);
                    $("#txt_existencia").val(existencia);
                     $("#txt_fn").val(fecha_ingreso);
                     
                
            });
            
        </script>
    </body>
    
</html>