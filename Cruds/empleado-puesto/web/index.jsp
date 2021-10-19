<%-- 
    Document   : index
    Created on : 6/09/2021, 16:39:18
    Author     : olive
--%>
<%@page import="modelo.Puestos" %>
<%@page import="modelo.Empleados" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body>
       
        <h1>Formulario Empleados</h1>
         <div class="container pt-5">
        <form action = "sr_empleados" method="post" class= "form-group">
            <label for="lbl_id" ><b>ID</b></label>
         <input type="text" name="txt_id" id="txt_id" class="form-control" value="0" readonly="">
           <label for="lbl_nombres" ><b>Nombres</b></label>
           <input type="text" name="txt_nombres" id="txt_nombres" class="form-control" placeholder="Ejemplo: Nombre1 Nombre2">
           <label for="lbl_apellidos" ><b>Apellidos</b></label>
           <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control" placeholder="Ejemplo: Apellido1 Apellido2">
           <label for="lbl_direccion" ><b>Direccion</b></label>
           <input type="text" name="txt_direccion" id="txt_direccion" class="form-control" placeholder="Ejemplo: #casa ave.calle lugar">
           <label for="lbl_telefono" ><b>Telefono</b></label>
           <input type="number" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="Ejemplo: 12345678">
           <label for="lbl_dpi" ><b>DPI</b></label>
           <input type="text" name="txt_dpi" id="txt_dpi"class="form-control">
           <label for="lbl_genero" ><b>Genero</b></label>
           <input type="text" name="txt_genero" id="txt_genero"class="form-control" placeholder="Ejemplo: f= femenino y  m= masculino">
           <label for="lbl_fn" ><b>Nacimiento</b></label>
           <input type="date" name="txt_fn" id="txt_fn" class="form-control" placeholder=" YYY-MM-DD">
            <label for="lbl_puesto"  ><b>Puesto</b></label>
           <select name="drop_puesto" class="form-select" id="drop_puesto">
               <% 
                Puestos puesto = new Puestos();
                HashMap<String,String> drop = puesto.drop_sangre();
                for(String i: drop.keySet()){
                    out.println("<option value = '"+ i +"'>"+ drop.get(i)+"</option>");
                }
                   
                %>
             
               
               
               
           </select>
           <label for="lbl_fil"><b>Inicio_labores</b></label>
           <input type="date" name="txt_fil" id="txt_fil" class="form-control" placeholder=" YYY-MM-DD">
           <label for="lbl_fin"><b>Ingreso</b></label>
           <input type="date" name="txt_fin" id="txt_fin" class="form-control" placeholder=" YYY-MM-DD">
           <br>
           <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
           <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success  btn-lg">Modificar</button>
           <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger  btn-lg "onclick ">Eliminar</button>
          
        </form>
                <br>
           <table class="table table-bordered">
    <thead>
      <tr>
        
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>Direccion</th>
        <th>Telefono</th>
        <th>DPI</th>
        <th>Genero</th>
        <th>nacimiento</th>
        <th>Puesto</th>
        <th>Inicio_labores</th>
        <th>Ingreso</th>
       
      </tr>
    </thead>
    <tbody id="tbl_empleados">
        <%
             Empleados empleados = new Empleados();
             DefaultTableModel tabla= new DefaultTableModel();
             tabla = empleados.leer();
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
                  out.println("<td>"+ tabla.getValueAt(t, 9)+"</td>");
                   out.println("<td>"+ tabla.getValueAt(t, 10)+"</td>");
                   
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
            $('#tbl_empleados').on('click','tr td',function(evt){
                var target,id,idP,nombres,apellidos,direccion,telefono,DPI,genero,fecha_nacimiento,fecha_inicio_labores,fecha_ingreso;
                target = $(event.target);
                id = target.parent().data('id');
                 idP= target.parent().data('idP');
                nombres = target.parent("tr").find("td").eq(0).html();
                 apellidos = target.parent("tr").find("td").eq(1).html();
                  direccion = target.parent("tr").find("td").eq(2).html();
                   telefono = target.parent("tr").find("td").eq(3).html();
                    DPI = target.parent("tr").find("td").eq(4).html();
                     genero= target.parent("tr").find("td").eq(5).html();
                       fecha_nacimiento = target.parent("tr").find("td").eq(6).html();
                       fecha_inicio_labores = target.parent("tr").find("td").eq(7).html();
                        fecha_ingreso = target.parent("tr").find("td").eq(8).html(); 
                
 $("#txt_id").val(id);
                $("#txt_nombres").val(nombres);
                 $("#txt_apellidos").val(apellidos);
                  $("#txt_direccion").val(direccion);
                   $("#txt_telefono").val(telefono);
                    $("#txt_dpi").val(DPI);
                    $("#txt_genero").val(genero);
                     $("#txt_fn").val(fecha_nacimiento);
                     $("#txt_fil").val(fecha_inicio_labores);
                     $("#txt_fin").val(fecha_ingreso);
                
            });
            
        </script>
            
    </body>
</html>
