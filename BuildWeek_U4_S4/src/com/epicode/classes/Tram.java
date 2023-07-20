package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.epicode.enums.Stato;


@Entity
public class Tram extends MezzoTrasporto {

	public Tram() {
		super();

	}

	public Tram(Long targa, int capienzaPersone, Stato stato, LocalDate inizioServizio, LocalDate fineServizio,
			LocalDate inizioManutenzione, LocalDate fineManutenzione, boolean validazione) {
		super(targa, capienzaPersone, stato, inizioServizio, fineServizio, inizioManutenzione, fineManutenzione, validazione);
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
	

