package com.epicode.DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.classes.CartaDaViaggio;
import com.epicode.classes.RivenditoreAutorizzato;
import com.epicode.classes.Utente;


public class CartaDaViaggioDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
	EntityManager em = emf.createEntityManager();

	
	public void saveCartaDaViaggio(CartaDaViaggio c) throws SQLException {	

		em.getTransaction().begin();
    	em.persist(c);
    	em.getTransaction().commit();
    	System.out.println(c);
		
	}
	
	public void deleteCartaDaViaggio (long id) throws SQLException {
			
			em.getTransaction().begin();
	    	CartaDaViaggio carta = em.find(CartaDaViaggio.class, id);
	    	em.remove(carta);
	    	em.getTransaction().commit();
			System.out.println("Carta da viaggio cancellato correttamente");
			
		}
	
	public void getAllCartaDaViaggio() throws SQLException {
			
			Query query = em.createQuery("SELECT c FROM CartaDaViaggio", CartaDaViaggio.class);
			List<CartaDaViaggio> resultList = query.getResultList();
			resultList.forEach(e -> System.out.println(e));
			
		}
	
	public void findCarteDaViaggio(long id) throws SQLException {
		
		em.getTransaction().begin();
		CartaDaViaggio carta = em.find(CartaDaViaggio.class, id);
		em.getTransaction().commit();
		System.out.println(carta);
		
	}
	
	public int getByDate(LocalDate dataIniziale, LocalDate dataFinale, RivenditoreAutorizzato r ) {
	
		
	Query query = em.createQuery("SELECT c FROM CartaDaViaggio WHERE c.dataEmissione > :dataIniziale AND c.dataEmissione < :dataFinale");
	query.setParameter("dataIniziale" , dataIniziale );
	query.setParameter("dataFinale", dataFinale);
	List<CartaDaViaggio> resultList = query.getResultList();
	int contatore = (int) resultList.stream()
	.filter(carta -> carta.getRivenditoreAutorizzato() == r).count();
	System.out.println("Sono stati stampati dal " + r + ":" + contatore + " biglietti/abbonamenti");
	return contatore;
	
	}
	
	public static void CartaDaViaggio () {};
}
