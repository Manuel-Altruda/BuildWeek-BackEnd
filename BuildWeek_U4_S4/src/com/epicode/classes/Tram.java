package com.epicode.classes;

import java.time.LocalDate;

import com.epicode.enums.Stato;

public class Tram extends MezzoTrasporto {
	
	//Riprende i metodi dalla classe astratta, non ce bisogno di aggiungere getter/setter...!!!
	

	public Tram() {
		super();
	
	}

	public Tram(String targa, int capienzaPersone, Stato stato, LocalDate inizioServizio, LocalDate fineServizio,
			LocalDate inizioManutenzione, LocalDate fineManutenzione, boolean validazione) {
		super(targa, capienzaPersone, stato, inizioServizio, fineServizio, inizioManutenzione, fineManutenzione, validazione);

	}



	}
	

