package com.epicode.DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.classes.Utente;

public class UtenteDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
	private static EntityManager em = emf.createEntityManager();
	
	
	public void saveUser(Utente utente) {
		
		em.getTransaction().begin();
    	em.persist(utente);
    	em.getTransaction().commit();
    	System.out.println(utente);
		
	}
	
	public void deleteUser (long id) {
		
		em.getTransaction().begin();
    	Utente utente = em.find(Utente.class, id);
    	em.remove(utente);
    	em.getTransaction().commit();
		System.out.println("Utente cancellato correttamente");
		
	}
	
	public void getById (long id) {
		
		em.getTransaction().begin();
		Utente utente = em.find(Utente.class, id);
		em.getTransaction().commit();
		System.out.println(utente);
		
	}
	
	public void getAllUsers() throws SQLException {
		
		Query query = em.createQuery("SELECT u FROM Utente u", Utente.class);
		List<Utente> resultList = query.getResultList();
		resultList.forEach(e -> System.out.println(e));
		
	}
	
	
	public static void UtenteDAO() {};
    
}