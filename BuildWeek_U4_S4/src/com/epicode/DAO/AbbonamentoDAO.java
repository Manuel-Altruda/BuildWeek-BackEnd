package com.epicode.DAO;


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

	
	
	

}