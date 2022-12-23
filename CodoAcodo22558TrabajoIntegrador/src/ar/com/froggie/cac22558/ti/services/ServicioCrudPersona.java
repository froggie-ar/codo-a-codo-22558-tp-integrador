package ar.com.froggie.cac22558.ti.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import ar.com.froggie.cac22558.ti.exceptions.NonExistentEntityException;
import ar.com.froggie.cac22558.ti.model.Persona;
import ar.com.froggie.cac22558.ti.persistence.PersonaDao;

public class ServicioCrudPersona {
		
	private PersonaDao personaDao;
		
	public ServicioCrudPersona () {
		
		personaDao = new PersonaDao();
				
	}
	
	public Persona darDeAlta (Persona p) {
		
		try {

			personaDao.iniciarTransaccion();
			
			p = personaDao.crear(p);	
		
			personaDao.confirmarTransaccion();
		
		} catch (Exception e) {
		
			personaDao.deshacerTransaccion();
			
			throw e;
			
		}
		
		return p;
				
	}
	
	public void modificar (Persona p) throws Exception {
		
		try {
			
			personaDao.iniciarTransaccion();
			
	        personaDao.modificar(p);
	        
	        personaDao.confirmarTransaccion();

		} catch (Exception e) {
			
			personaDao.deshacerTransaccion();
			
			throw e;
		}
	            
	}
	
	public void darDeBaja (Persona p) throws Exception {

		try {
			
			personaDao.iniciarTransaccion();

			personaDao.eliminar(p);
	        
	        personaDao.confirmarTransaccion();

		} catch (Exception e) {
			
			personaDao.deshacerTransaccion();
			
			throw e;
		}

	}
	
	public List<Persona> listarTodas () {
		
		return personaDao.buscarEntidades();
		
	}
	
	public Persona obtenerPersonaPorId (Long id) {
		
		return personaDao.buscarPorId (id);
		
	}
	
}
