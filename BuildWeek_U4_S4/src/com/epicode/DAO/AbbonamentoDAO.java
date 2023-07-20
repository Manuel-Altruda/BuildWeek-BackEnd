package com.epicode.DAO;


import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.classes.Abbonamento;
import com.epicode.classes.CartaDaViaggio;

public class AbbonamentoDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
	EntityManager em = emf.createEntityManager();
	
	

	public void findUtenteByNumeroTessera(long id) {
    	CartaDaViaggio carta = em.find(CartaDaViaggio.class, id);
		Query query = em.createQuery("SELECT u FROM CartaDaViaggio u WHERE u.dataScadenza = :dataScadenza");
	    query.setParameter("dataScadenza", carta);
	    Abbonamento liliPad = (Abbonamento) query.getSingleResult();
	    System.out.println(liliPad);
	    
	}

	public void saveAbbonamento(CartaDaViaggio c) throws SQLException {	

		em.getTransaction().begin();
    	em.persist(c);
    	em.getTransaction().commit();
    	System.out.println(c);
		
	}
	
	public void deleteAbbonamento (long id) throws SQLException {
			
			em.getTransaction().begin();
	    	CartaDaViaggio carta = em.find(CartaDaViaggio.class, id);
	    	em.remove(carta);
	    	em.getTransaction().commit();
			System.out.println("Carta da viaggio cancellato correttamente");
			
		}
	
	public void getAllAbbonamento() throws SQLException {
			
			Query query = em.createQuery("SELECT c FROM CartaDaViaggio", CartaDaViaggio.class);
			List<CartaDaViaggio> resultList = query.getResultList();
			resultList.forEach(e -> System.out.println(e));
			
		}
	
	public void findAbbonamento(long id) throws SQLException {
		
		em.getTransaction().begin();
		CartaDaViaggio carta = em.find(CartaDaViaggio.class, id);
		em.getTransaction().commit();
		System.out.println(carta);
		
	}
	
	

}