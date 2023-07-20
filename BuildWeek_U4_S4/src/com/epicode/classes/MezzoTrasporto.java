package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import com.epicode.enums.Stato;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MezzoTrasporto {
	
@Id
private Long targa;

private int capienzaPersone;
private Stato stato;
private LocalDate inizioServizio;
private LocalDate fineServizio;
private LocalDate inizioManutenzione;
private LocalDate fineManutenzione;
private boolean validazione;

public MezzoTrasporto(){}

public MezzoTrasporto(Long targa, int capienzaPersone, Stato stato, LocalDate inizioServizio, LocalDate fineServizio,
		LocalDate inizioManutenzione, LocalDate fineManutenzione, boolean validazione) {
	super();
	this.targa = targa;
	this.capienzaPersone = capienzaPersone;
	this.stato = stato;
	this.inizioServizio = inizioServizio;
	this.fineServizio = fineServizio;
	this.inizioManutenzione = inizioManutenzione;
	this.fineManutenzione = fineManutenzione;
	this.validazione = validazione;
}

public Long getTarga() {
	return targa;
}

public void setTarga(Long i) {
	this.targa = i;
}

public int getCapienzaPersone() {
	return capienzaPersone;
}

public void setCapienzaPersone(int capienzaPersone) {
	this.capienzaPersone = capienzaPersone;
}

public Stato getStato() {
	return stato;
}

public void setStato(Stato stato) {
	this.stato = stato;
}

public LocalDate getInizioServizio() {
	return inizioServizio;
}

public void setInizioServizio(LocalDate inizioServizio) {
	this.inizioServizio = inizioServizio;
}

public LocalDate getFineServizio() {
	return fineServizio;
}

public void setFineServizio(LocalDate fineServizio) {
	this.fineServizio = fineServizio;
}

public LocalDate getInizioManutenzione() {
	return inizioManutenzione;
}

public void setInizioManutenzione(LocalDate inizioManutenzione) {
	this.inizioManutenzione = inizioManutenzione;
}

public LocalDate getFineManutenzione() {
	return fineManutenzione;
}

public void setFineManutenzione(LocalDate fineManutenzione) {
	this.fineManutenzione = fineManutenzione;
}

public boolean isValidazione() {
	return validazione;
}

public void setValidazione(boolean validazione) {
	this.validazione = validazione;
};



}



