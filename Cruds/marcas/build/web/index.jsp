<%-- 
    Document   : index
    Created on : 18/10/2021, 13:57:45
    Author     : olive
--%>

<%@page import="modelo.Marca" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body>
        <div>
                  <h1>Formulario Marcas</h1>
     
        </div>
 
         <div class="container pt-5">
            
        <form action = "sr_marca" method="post" class= "form-group">
         <label for="lbl_id" ><b>ID</b></label>
         <input type="text" name="txt_id" id="txt_id" class="form-control" value="0" readonly="">
           <label for="lbl_marca" ><b>Marca</b></label>
           <input type="text" name="txt_marca" id="txt_marca" class="form-control" placeholder="Ejemplo: Nombre1 Nombre2">
          
           <br>
           <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
           <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success  btn-lg">Modificar</button>
           <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger  btn-lg "onclick ">Eliminar</button>
          
       
        </form>
    
             <br>
           <table class="table table-bordered">
    <thead>
      <tr>
        
        <th>Marca</th>
        
      </tr>
     </thead>
    <tbody id="tbl_marca">
         <%
             Marca marca = new Marca();
             DefaultTableModel tabla= new DefaultTableModel();
             tabla = marca.leer();
             for(int t=0; t<tabla.getRowCount();t++){
                out.println("<tr data-id="+tabla.getValueAt(t, 0)+">");
                out.println("<td>"+ tabla.getValueAt(t, 1)+"</td>");
                
                
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
            $('#tbl_marca').on('click','tr td',function(evt){
                var target,id,marca;
                target = $(event.target);
                id = target.parent().data('id');
                marca = target.parent("tr").find("td").eq(0).html();
                
 $("#txt_id").val(id);
                $("#txt_marca").val(marca);
                
                     
                
            });
            
        </script>
  </body>  
</html>
