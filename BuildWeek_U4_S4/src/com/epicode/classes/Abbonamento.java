package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;

import com.epicode.enums.Periodicita;

@Entity
public class Abbonamento extends CartaDaViaggio {
	
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Utente utente;
	
	private LocalDate dataScadenza;
	
	public Abbonamento(Periodicita periodicita, LocalDate dataScadenza, Utente utente) {
		super();
		this.periodicita = periodicita;
		this.dataScadenza = dataScadenza;
		this.utente = utente;
	}

	public Abbonamento() {}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	@Override
	public String toString() {
		return "Abbonamento [periodicita=" + periodicita + ", dataScadenza=" + dataScadenza + "]";
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
}
