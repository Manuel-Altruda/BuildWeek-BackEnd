package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.epicode.enums.Stato;


@Entity
public class Tram extends MezzoTrasporto {

	public Tram() {
		super();

	}

	

	public Tram(Long targa, Long dataPartenza, Long endDate, int capienzaPersone, Stato stato, LocalDate inizioServizio,
			LocalDate fineServizio, LocalDate inizioManutenzione, LocalDate fineManutenzione, boolean validazione) {
		super(targa, dataPartenza, endDate, capienzaPersone, stato, inizioServizio, fineServizio, inizioManutenzione,
				fineManutenzione, validazione);
		
	}



	public Long getTarga() {
		return targa;
	}

}
	

