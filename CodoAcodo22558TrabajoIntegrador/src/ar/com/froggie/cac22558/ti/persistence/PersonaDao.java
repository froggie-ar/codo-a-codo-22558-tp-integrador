package ar.com.froggie.cac22558.ti.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ar.com.froggie.cac22558.ti.exceptions.NonExistentEntityException;
import ar.com.froggie.cac22558.ti.model.Persona;


public class PersonaDao extends Dao<Persona, Long>{
	
	/*
	 * PersonaDao se encarga de todas las operaciones con la base de datos 
	 * relacionadas a la entidad Persona.
	 * 
	 * Ojo: el manejo de transacciones lo tiene que hacer la capa de servicios
	 * o logica del negocio.
	 * 
	 */
			
	public PersonaDao() {
		
		super();
		
	}
	
	@Override
	public Persona crear(Persona p) {
							
		em.persist(p);
		em.flush();
		em.refresh(p);	
			
		return p;
		
	}
	
	
	@Override
	public void modificar(Persona p) throws NonExistentEntityException {

        try {
            
        	// Para hacer un update necesitamos saber si existe la entidad de ante mano,
        	// Si existe, con el getReference la atachamos para luego hacer el merge
        	
    		Persona prs = em.getReference (Persona.class, p.getId().toString());

        } catch (EntityNotFoundException enfe) {
        	            	
            throw new NonExistentEntityException("La persona con id " + p.getId() + " ya no existe.", enfe);
        }
        
        em.merge(p);
        		
	}
	
	
	@Override
	public void eliminar(Persona p) throws NonExistentEntityException {
	    
		Persona prs;
        
        try {
            
        	prs = em.getReference (Persona.class, p.getId().toString());

        } catch (EntityNotFoundException enfe) {
        	
        	if (em.getTransaction().isActive())
        		em.getTransaction().rollback();
        	
            throw new NonExistentEntityException("La persona con id " + p.getId() + " ya no existe.", enfe);
        }
        
        // Notar que se remueve prs no p !!! esto es porque la entidad tiene que
        // estar atachada para poder ser removida
        
		em.remove(prs);
	            		
	}
	
	
	@Override
	public Persona buscarPorId (Long id) {

		return em.find (Persona.class, id.toString());	

	}
	
	
	public List<Persona> buscarEntidades (boolean all, int maxResults, int firstResult) {
		
        try {
        	
        	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        	
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
            
            Root<Persona> rootPersona = criteriaQuery.from(Persona.class);

            criteriaQuery.select(rootPersona);
            
            criteriaQuery.orderBy(criteriaBuilder.asc(rootPersona.get("dni")));
            
            Query query = em.createQuery(criteriaQuery);
            
            if (!all) {
            	
                query.setMaxResults(maxResults);
                
                query.setFirstResult(firstResult);
                
            }
            
            return query.getResultList();
            
        } finally {
        	            
        }
        
	}
	
	
	@Override
	public List<Persona> buscarEntidades() {
		
		return buscarEntidades (true, -1, -1);
		
	}
	
	
	@Override
	public Long contar() {
        
		try {
            
        	CriteriaQuery criteriaQuery = em.getCriteriaBuilder().createQuery();
            
            Root<Persona> rootPersona = criteriaQuery.from(Persona.class);
            
            criteriaQuery.select( em.getCriteriaBuilder().count(rootPersona) );
            
            Query query = em.createQuery(criteriaQuery);
            
            return (Long) query.getSingleResult();
            
        } finally {
        	
        }
        
	}
	
	
}
