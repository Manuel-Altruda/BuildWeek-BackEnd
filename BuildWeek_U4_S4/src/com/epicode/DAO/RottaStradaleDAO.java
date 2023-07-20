package com.epicode.DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.classes.MezzoTrasporto;
import com.epicode.classes.RottaStradale;

public class RottaStradaleDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
	EntityManager em = emf.createEntityManager();

	public void saveRottaStradaleDAO(RottaStradale rotta) throws SQLException {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
		EntityManager em = emf.createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(rotta);
            em.getTransaction().commit();
            System.out.println(rotta);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
		
	}
	
	public void deleteRottaStradaleDAO (long coordinateTratta) throws SQLException {
		em.getTransaction().begin();
		RottaStradale rotta = em.find(RottaStradale.class, coordinateTratta);
    	em.remove(rotta);
    	em.getTransaction().commit();
		System.out.println("Rotta stradale cancellata correttamente");	
	}
	
	public void getRottaStradaleDAO() throws SQLException {
		Query query = em.createQuery("SELECT rotta FROM RottaStradale", RottaStradale.class);
		List<RottaStradale> resultList = query.getResultList();
		resultList.forEach(e -> System.out.println(e));
	}
	
	public void findRottaStradaleDAO(long coordinateTratta) throws SQLException {
		em.getTransaction().begin();
		RottaStradale rotta = em.find(RottaStradale.class, coordinateTratta);
		em.getTransaction().commit();
		System.out.println(rotta);
	}
	
	public void tempoImpiegato(long coordinateTratta) throws SQLException {
		//bisogna trova un modo per reperire gli orari e sottrarli per avere l'effettiva durata
	}
}
