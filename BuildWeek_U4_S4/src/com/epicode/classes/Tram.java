package com.epicode.classes;

import java.time.LocalDate;


import javax.persistence.Entity;

import com.epicode.enums.Stato;

@Entity
public class Tram extends MezzoTrasporto {
	
	//Riprende i metodi dalla classe astratta, non ce bisogno di aggiungere getter/setter...!!!
	

	public Tram() {
		
	
	}

	public Tram(String targa, int capienzaPersone, Stato stato, LocalDate inizioServizio, LocalDate fineServizio,
			LocalDate inizioManutenzione, LocalDate fineManutenzione, boolean validazione) {
		super(targa, capienzaPersone, stato, inizioServizio, fineServizio, inizioManutenzione, fineManutenzione, validazione);

	}



	}
	

