package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;

public class Biglietto extends CartaDaViaggio {
	private boolean obliterato;
	@ManyToOne
	private Utente utente;

	public Biglietto(LocalDate dataEmissione, RivenditoreAutorizzato rivenditoreAutorizzato, boolean obliterato,
			Utente utente) {
		super(dataEmissione, rivenditoreAutorizzato);
		this.obliterato = obliterato;
		this.utente = utente;
	}
	
	public Biglietto() {}

	public boolean isObliterato() {
		return obliterato;
	}

	public void setObliterato(boolean obliterato) {
		this.obliterato = obliterato;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Biglietto [obliterato=" + obliterato + ", utente=" + utente + "]";
	}
	
}
