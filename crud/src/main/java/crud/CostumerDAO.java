package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import crud.model.Costumer;

@Transactional
public class CostumerDAO {
	
	@PersistenceContext
	private static EntityManager em;
	 
	public CostumerDAO(){
		
		if(em != null)
			return;
		
		EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("CostumerPU");
        em = emf.createEntityManager();
        
	}

	public List<Costumer> list(){
		try{
			if(em != null)
				return em.createQuery("SELECT c FROM costumers c", Costumer.class)
			.getResultList();
			else
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
    public void create(Costumer costumer) {
    	try{
    		if(costumer != null){
        		em.getTransaction().begin();
    	        em.persist(costumer);
    	        em.getTransaction().commit();
        	} 
		}
		catch(Exception e){
			e.printStackTrace();
		} 
    }
    
    public void edit(Costumer costumer) {
    	if(costumer != null){
    		Costumer edit = em.find(Costumer.class, costumer.getId());
    		if(edit != null){
    			em.getTransaction().begin();
    	        edit.setName(costumer.getName());
    	        edit.setCpf(costumer.getCpf());
    	        em.getTransaction().commit();
    		}
    	}  
    }
    
    public void remove(Costumer costumer) {
    	try{
    		if(costumer != null){
    			em.getTransaction().begin();
        		em.remove(costumer);
        		em.getTransaction().commit();
        	}
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
}
