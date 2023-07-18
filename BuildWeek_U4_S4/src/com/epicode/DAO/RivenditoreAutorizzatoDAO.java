package com.epicode.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.classes.RivenditoreAutorizzato;
import com.epicode.classes.Utente;

public class RivenditoreAutorizzatoDAO {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public RivenditoreAutorizzatoDAO() {
        emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
        em = emf.createEntityManager();
    }
	
	public void saveRivenditoreAutorizzato(RivenditoreAutorizzato c) {
		
		em.getTransaction().begin();
    	em.persist(c);
    	em.getTransaction().commit();
    	System.out.println(c);
		
	};
	
	public void delete(long id) {
		
		em.getTransaction().begin();
		RivenditoreAutorizzato elemento = em.find(RivenditoreAutorizzato.class,id);
    	em.remove(elemento);
    	em.getTransaction().commit();
		
	};
	
	public void getAllRivenditori() {
		
		Query query = em.createQuery("SELECT r FROM RivenditoreAutorizzato r", Utente.class);
		List<RivenditoreAutorizzato> resultList = query.getResultList();
		resultList.forEach(e -> System.out.println(e));
		
	};
	
	
}
