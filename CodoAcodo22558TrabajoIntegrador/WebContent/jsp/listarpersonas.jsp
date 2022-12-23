<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ page import="ar.com.froggie.cac22558.ti.model.Persona" %>
<%@ page import="ar.com.froggie.cac22558.ti.services.ServicioCrudPersona" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>ABM de Personas</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<link rel="stylesheet" href="./css/listarpersonas.css">
	</head>
	
	<body>
	
		<div class="container">

			<header>
		
				<p class="h3 mb-3">Lista de Personas</p>
						
				<nav class="navbar bg-light nav-justified mb-3">
				  
				  <form class="container-fluid justify-content-start">
					  <a href="./ControladorPersonas?accion=agregar" class="btn btn-outline-primary col-3">Agregar Persona</a>
	                  <a href="./ControladorPersonas?accion=listar"  class="btn btn-outline-success col-3 ms-auto me-1">Refrescar</a>
				  </form>
				  
				</nav>	
				
			</header>
			
			<main>
			
				<div class="row col-12 ms-1">
				
					<table class="table table-bordered table-hover">
					
						<thead class="table-primary">
							<tr>
								<th>Id</th>
								<th>DNI</th>
								<th>Apellido</th>
								<th>Nombre</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<%
							ServicioCrudPersona srvCrudPersona = new ServicioCrudPersona();
							
							List<Persona> lstPersonas = srvCrudPersona.listarTodas();
							
							if (!lstPersonas.isEmpty()) {
								
								Iterator<Persona> itrPersonas = lstPersonas.iterator();
								
								Persona persona = null;
								
								while (itrPersonas.hasNext()) {
									
									persona = itrPersonas.next();
							
						%>
								<tbody>
									<tr>
										<td> <%= persona.getId() %> </td>
										<td> <%= persona.getDni() %> </td>
										<td> <%= persona.getApellido() %> </td>
										<td> <%= persona.getNombre() %> </td>
										<td class="tabcol-center">
											<a class="btn btn-outline-warning" id="modificar-persona" href="./ControladorPersonas?accion=modificar&id=<%= persona.getId() %>">Editar</a>
										</td>
										<td class="tabcol-center">
											<a class="btn btn-outline-danger" id="eliminar-persona" href="./ControladorPersonas?accion=eliminar&id=<%= persona.getId() %>">Eliminar</a>
										</td>
										
									</tr>
								</tbody>
							
						<%
								} 
							} 
						%>
								
					</table>
					
				</div>
				
			</main>
			
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
		
	</body>
	
</html>



