package ar.com.froggie.cac22558.ti.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.froggie.cac22558.ti.exceptions.ServletOperationNotSupported;
import ar.com.froggie.cac22558.ti.exceptions.TheIdProvidedCannotBeNull;
import ar.com.froggie.cac22558.ti.model.Persona;
import ar.com.froggie.cac22558.ti.services.ServicioCrudPersona;

public class ControladorPersonas extends HttpServlet{
	
	/*
	 * Recordar que hay que configurar el web.xml los elementos <servlet> y 
	 * <servlet-mapping>
	 * 
	 */

	final String JSP_LISTAR    = "./jsp/listarpersonas.jsp";
	final String JSP_AGREGAR   = "./jsp/agregarpersona.jsp";	
	final String JSP_MODIFICAR = "./jsp/modificarpersona.jsp";	
	final String JSP_ELIMINAR  = "./jsp/eliminarpersona.jsp";	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioCrudPersona servicioPersona = new ServicioCrudPersona();

		String jsp = "";
		
		String accion = request.getParameter("accion");
		
		accion = (null == accion) ? JSP_LISTAR : accion.toLowerCase();
	       
		if ("listar".equals(accion)) {
        
        	jsp = JSP_LISTAR;
		
		} else if ("agregar".equals(accion)) {
			
			jsp = JSP_AGREGAR;

		} else if ("modificar".equals(accion) || "eliminar".equals(accion)) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			
			if (null == id) {
				throw new TheIdProvidedCannotBeNull ("");
			}
			
			Persona persona = servicioPersona.obtenerPersonaPorId(id);
			
			request.setAttribute("nombre", persona.getNombre());
			request.setAttribute("apellido", persona.getApellido());
			request.setAttribute("dni", persona.getDni());
			request.setAttribute("id", id);

			if ("modificar".equals(accion)) {
				
				jsp = JSP_MODIFICAR;
				
			} else {
	    		
				jsp = JSP_ELIMINAR;
				
			}
 
		} else {
        		
       		throw new ServletOperationNotSupported (accion);
        		
        }

		RequestDispatcher view = request.getRequestDispatcher(jsp);
		
        view.forward(request, response);
        
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServicioCrudPersona servicioPersona = new ServicioCrudPersona();

		String accion = request.getParameter("accion");
		
		accion = (null == accion) ? "" : accion.toLowerCase();
		
		Persona persona = new Persona();
			
		persona.setNombre (request.getParameter("nombre"));
		persona.setApellido (request.getParameter("apellido"));
		persona.setDni (request.getParameter("dni"));
		persona.setId (request.getParameter("id"));
		
        switch (accion) {   	
               
        	case "confirmaragregar":
        		
        		try {
        			
        			servicioPersona.darDeAlta(persona);
        			
        		} catch (Exception e) {
        			
        			throw new ServletException ( "Error al insertar datos de la persona: " + e.getMessage());
        			
        		}
        		
        		break;
        	
        	case "confirmarmodificar":
        		
        		try {
        			
        			servicioPersona.modificar(persona);
        				        			
        		} catch (Exception e) {
        			
        			throw new ServletException ( "Error al actualizar datos de la persona: " + e.getMessage());

        		}
        		
        		break;
        	
        	case "confirmareliminar":
        		
        		try {
        			
        			servicioPersona.darDeBaja(persona);
        			
        		} catch (Exception e){
        			
        			throw new ServletException ("Error al eliminar datos de la persona: " + e.getMessage());

        		}

        		break;

        	default:
        		
        		throw new ServletOperationNotSupported (accion);
        		
        }
        
		RequestDispatcher view = request.getRequestDispatcher(JSP_LISTAR);
		
        view.forward(request, response);
        
	}	

}
