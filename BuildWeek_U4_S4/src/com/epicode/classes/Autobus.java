package com.epicode.classes;

import java.time.LocalDate;

import com.epicode.enums.Stato;

public class Autobus extends MezzoTrasporto {

	public Autobus() {
		super();

	}

	public Autobus(Long targa, Long dataPartenza, Long endDate, int capienzaPersone, Stato stato,
			LocalDate inizioServizio, LocalDate fineServizio, LocalDate inizioManutenzione, LocalDate fineManutenzione,
			boolean validazione) {
		super(targa, dataPartenza, endDate, capienzaPersone, stato, inizioServizio, fineServizio, inizioManutenzione,
				fineManutenzione, validazione);
		
	}

	



}
