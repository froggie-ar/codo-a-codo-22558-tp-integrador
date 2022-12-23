package ar.com.froggie.cac22558.ti.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import ar.com.froggie.cac22558.ti.exceptions.NonExistentEntityException;
import ar.com.froggie.cac22558.ti.model.Persona;

public abstract class Dao <T, K>{

	/*
	 * http://expertojava.ua.es/experto/restringido/2015-16/jpa/jpa.html
	 * 
	 * Como primera medida implementamos el DAO genérico
	 * 
	 */
	
	static EntityManager em = null;
	
	public Dao () {
		
		if (em == null) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cac22558PersistenceUnit");
			
			//System.out.println("is open connection: " + emf.isOpen());
			
			em = emf.createEntityManager();
		}

	}
	
	public void iniciarTransaccion() {
		
		em.getTransaction().begin();
		
	}
	
	public void confirmarTransaccion() {
		
		em.getTransaction().commit();
	}
	
	public void deshacerTransaccion () {
		
    	if (em.getTransaction().isActive())
    		em.getTransaction().rollback();
		
	}
	
	public abstract T crear (T t);
			
	public abstract void modificar (T t) throws NonExistentEntityException ;
	
	public abstract void eliminar (T t) throws NonExistentEntityException;
			
	public abstract T buscarPorId (K id); 
	
	public abstract List<T> buscarEntidades ();
	
	public abstract Long contar();
	
	
}

