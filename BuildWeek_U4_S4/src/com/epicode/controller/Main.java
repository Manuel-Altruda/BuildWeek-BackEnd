package com.epicode.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.classes.Biglietto;
import com.epicode.classes.RivenditoreAutorizzato;

import utils.JpaUtil;

public class Main {
	
	public static void main(String[] args) {
		
		RivenditoreAutorizzato tabacchino1 = new RivenditoreAutorizzato();
		tabacchino1.setCarteDaViaggioVendute(1);
		tabacchino1.setDataEmissione(null);
		
		
		Biglietto b1 = new Biglietto();
		b1.setDataEmissione(LocalDate.of(2023, 2, 12));
		
	}
	
	public static void aggiungiBiglietto(Biglietto b) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		} catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Errore durante il salvataggio " + ex.getMessage());
		} finally {
			em.close();
		}
	}
}
