package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import com.epicode.DAO.*;


import com.epicode.classes.Biglietto;
import com.epicode.classes.RivenditoreAutorizzato;
import com.epicode.classes.Utente;




public class Main {
	
	
	public static void main(String[] args) throws SQLException {
		
		RivenditoreAutorizzatoDAO rivenditoreAutorizzatoDAO = new RivenditoreAutorizzatoDAO();
		UtenteDAO utenteDAO = new UtenteDAO();
		CartaDaViaggioDAO cartaDaViaggioDAO = new CartaDaViaggioDAO();
		
		RivenditoreAutorizzato r1 = new RivenditoreAutorizzato(10, LocalDate.of(2023, 7, 18));
		RivenditoreAutorizzato r2 = new RivenditoreAutorizzato(150, LocalDate.of(2022, 6, 19));
		
		Utente utente1 = new Utente("Mariaca", "Sossialla");
		Utente utente2 = new Utente("Maridell", "Cuozzamma");
		
		Biglietto b1 = new Biglietto(LocalDate.of(2020, 5, 11), r1 , true , utente1);
		Biglietto b2 = new Biglietto(LocalDate.of(2021, 11, 12), r2 , false , utente2);
		
		//rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r1);
		//rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r2);
		
		//utenteDAO.saveUser(utente1);
		//utenteDAO.saveUser(utente2);
		
		//cartaDaViaggioDAO.saveCartaDaViaggio(b1);
		//cartaDaViaggioDAO.saveCartaDaViaggio(b2);
		
		//utenteDAO.deleteUser(2);
		
		Biglietto b3 = new Biglietto();
		b3.setDataEmissione(LocalDate.of(2023, 2, 12));
		
		cartaDaViaggioDAO.getByDate(LocalDate.of(2021, 7, 18),  LocalDate.of(2024, 5, 18), r1);
		
	}
	
	
}
