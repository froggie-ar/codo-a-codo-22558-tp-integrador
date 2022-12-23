<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Modificación de Persona</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	</head>
	
	<body>
		
		<div class="container">
			
			<header>
				<h3>Actualización de Personas</h3>
			</header>
			
			<main>
				
				<form class="row" method="post" action="./ControladorPersonas?accion=confirmarmodificar">
				
					<fieldset>
						<legend>Datos personales</legend>
	
						<div class="mb-3">
	  						<label for="nombrePersona" class="form-label">Nombre</label>
	  						<input type="text" class="form-control" id="nombrePersona" name="nombre" value="${nombre}" required>
						</div>
						
						<div class="mb-3">
	  						<label for="apellidoPersona" class="form-label">Apellido</label>
	  						<input type="text" class="form-control" id="apellidoPersona" name="apellido" value="${apellido}" required>
						</div>
	
						<div class="mb-3 col-4">
	  						<label for="dniPersona" class="form-label">DNI</label>
	  						<input type="text" class="form-control" id="dniPersona" name="dni" value="${dni}" required>
						</div>
	
					</fieldset>
								
					<input type="hidden" name="id" value="${id}"/>
					
					<div class="row">
		
						<div class="col-6">
							<button id="modificar-persona-boton-confirmar" class="btn btn-outline-primary w-100 mb-2" type="submit">Confirmar Actualización</button>
						</div>
						        
						<div class="col-3">
							<button id="modificar-persona-boton-volver" class="btn btn-outline-danger w-100 mb-2" type="button">Cancelar</button>
						</div>
				
					</div>
					
				</form>
			
			</main>
			
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
		
		<script type="text/javascript" src="./js/common.js"></script>	
		<script type="text/javascript" src="./js/modificarpersona.js"></script>	
		
	</body>
	
</html>
