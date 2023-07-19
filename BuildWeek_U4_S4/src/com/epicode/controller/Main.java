package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import com.epicode.DAO.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.classes.Biglietto;
import com.epicode.classes.RivenditoreAutorizzato;
import com.epicode.classes.Utente;

import utils.JpaUtil;



public class Main {
	
	
	public static void main(String[] args) throws SQLException {
		
		RivenditoreAutorizzatoDAO rivenditoreAutorizzatoDAO = new RivenditoreAutorizzatoDAO();
		UtenteDAO utenteDAO = new UtenteDAO();
		CartaDaViaggioDAO cartaDaViaggioDAO = new CartaDaViaggioDAO();
		
		RivenditoreAutorizzato r1 = new RivenditoreAutorizzato(LocalDate.of(2023, 7, 18));
		RivenditoreAutorizzato r2 = new RivenditoreAutorizzato(LocalDate.of(2022, 6, 19));
		
		Utente utente1 = new Utente("Marco", "Sossi");
		Utente utente2 = new Utente("Marie", "Cossa");
		
		Biglietto b1 = new Biglietto(LocalDate.of(2023, 9, 10), r1 , true , utente1);
		Biglietto b2 = new Biglietto(LocalDate.of(2023, 10, 11), r2 , false , utente2);
		
		rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r1);
		rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r2);
		
		utenteDAO.saveUser(utente1);
		utenteDAO.saveUser(utente2);
		utenteDAO.deleteUser(2);
		
		cartaDaViaggioDAO.saveCartaDaViaggio(b1);
		cartaDaViaggioDAO.saveCartaDaViaggio(b2);
		
		
		
		//Biglietto b1 = new Biglietto();
		//b1.setDataEmissione(LocalDate.of(2023, 2, 12));
		
	}
//	
//	public static void aggiungiBiglietto(Biglietto b) {
//		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//		try {
//			em.getTransaction().begin();
//			em.persist(b);
//			em.getTransaction().commit();
//		} catch(Exception ex) {
//			em.getTransaction().rollback();
//			System.out.println("Errore durante il salvataggio " + ex.getMessage());
//		} finally {
//			em.close();
//		}
//	}
}
