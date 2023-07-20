package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CartaDaViaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Utente utente;
	private LocalDate dataEmissione;
 
	@ManyToOne
	private RivenditoreAutorizzato rivenditoreAutorizzato;


	public CartaDaViaggio() {}


	public CartaDaViaggio(LocalDate dataEmissione, RivenditoreAutorizzato rivenditoreAutorizzato, Utente utente) {
		this.dataEmissione = dataEmissione;
		this.utente = utente;
		this.rivenditoreAutorizzato = rivenditoreAutorizzato;
	}


	public long getId() {
		return id;
	}
	
	public LocalDate getDataEmissione() {
		return dataEmissione;
	}
	
	
	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	
	
	public RivenditoreAutorizzato getRivenditoreAutorizzato() {
		return rivenditoreAutorizzato;
	}
	
	
	public void setRivenditoreAutorizzato(RivenditoreAutorizzato rivenditoreAutorizzato) {
		this.rivenditoreAutorizzato = rivenditoreAutorizzato;
	}
	
	
	@Override
	public String toString() {
		return "CartaDaViaggio [id=" + id + ", dataEmissione=" + dataEmissione + ", rivenditoreAutorizzato="
				+ rivenditoreAutorizzato + "]";
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


}
