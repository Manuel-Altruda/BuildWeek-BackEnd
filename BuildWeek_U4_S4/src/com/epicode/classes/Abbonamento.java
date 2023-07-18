package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;

import com.epicode.enums.Periodicita;

@Entity
public class Abbonamento extends CartaDaViaggio {
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;
	private LocalDate dataScadenza;
	
	public Abbonamento(Periodicita periodicita, LocalDate dataScadenza) {
		super();
		this.periodicita = periodicita;
		this.dataScadenza = dataScadenza;
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
	
}
