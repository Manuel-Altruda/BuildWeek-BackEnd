package com.epicode.DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.epicode.classes.Tessera;

public class TesseraDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
	EntityManager em = emf.createEntityManager();
	
	public Tessera findId(long id) {
		return em.find(Tessera.class, id);
	}
	
	public void saveTessera(Tessera t) throws SQLException {	

		em.getTransaction().begin();
    	em.persist(t);
    	em.getTransaction().commit();
    	System.out.println(t);
		
	}
	
	public void deleteTessera (long id) throws SQLException {
			
			em.getTransaction().begin();
			Tessera carta = em.find(Tessera.class, id);
	    	em.remove(carta);
	    	em.getTransaction().commit();
			System.out.println("Tessera cancellata correttamente");
			
		}
	
	public void getAllTessera() throws SQLException {
			
			Query query = em.createQuery("SELECT t FROM Tessera", Tessera.class);
			List<Tessera> resultList = query.getResultList();
			resultList.forEach(e -> System.out.println(e));
			
		}
}
