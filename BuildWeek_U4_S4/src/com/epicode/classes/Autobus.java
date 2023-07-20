package com.epicode.classes;

import java.time.LocalDate;

import com.epicode.enums.Stato;

public class Autobus extends MezzoTrasporto {

	public Autobus() {
		super();

	}

	public Autobus(String targa, int capienzaPersone, Stato stato, LocalDate inizioServizio, LocalDate fineServizio,
			LocalDate inizioManutenzione, LocalDate fineManutenzione, boolean validazione) {
		super(targa, capienzaPersone, stato, inizioServizio, fineServizio, inizioManutenzione, fineManutenzione, validazione);

	}


}
