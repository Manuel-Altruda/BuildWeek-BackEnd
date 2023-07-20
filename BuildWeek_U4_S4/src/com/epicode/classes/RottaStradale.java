package com.epicode.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RottaStradale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long coordinateTratta;
	private String zonaPartenza;
	private String capolinea;
	private int tempoMedioPercorrenza;
	private int tempoDiPercorrenza;
	private int ripetizioniPercorrenza;

	
	@ManyToOne
	private MezzoTrasporto mezzoTrasporto;


	public RottaStradale(long coordinateTratta, String zonaPartenza, String capolinea, int tempoMedioPercorrenza,
			int tempoDiPercorrenza, int ripetizioniPercorrenza, MezzoTrasporto mezzoTrasporto) {
		super();
		this.coordinateTratta = coordinateTratta;
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
		this.tempoMedioPercorrenza = tempoMedioPercorrenza;
		this.tempoDiPercorrenza = tempoDiPercorrenza;
		this.ripetizioniPercorrenza = ripetizioniPercorrenza;
		this.mezzoTrasporto = mezzoTrasporto;
	}


	public RottaStradale() {
		super();
	}


	public long getCoordinateTratta() {
		return coordinateTratta;
	}


	public void setCoordinateTratta(long coordinateTratta) {
		this.coordinateTratta = coordinateTratta;
	}


	public String getZonaPartenza() {
		return zonaPartenza;
	}


	public void setZonaPartenza(String zonaPartenza) {
		this.zonaPartenza = zonaPartenza;
	}


	public String getCapolinea() {
		return capolinea;
	}


	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}


	public int getTempoMedioPercorrenza() {
		return tempoMedioPercorrenza;
	}


	public void setTempoMedioPercorrenza(int tempoMedioPercorrenza) {
		this.tempoMedioPercorrenza = tempoMedioPercorrenza;
	}


	public int getTempoDiPercorrenza() {
		return tempoDiPercorrenza;
	}


	public void setTempoDiPercorrenza(int tempoDiPercorrenza) {
		this.tempoDiPercorrenza = tempoDiPercorrenza;
	}


	public int getRipetizioniPercorrenza() {
		return ripetizioniPercorrenza;
	}


	public void setRipetizioniPercorrenza(int ripetizioniPercorrenza) {
		this.ripetizioniPercorrenza = ripetizioniPercorrenza;
	}


	public MezzoTrasporto getMezzoTrasporto() {
		return mezzoTrasporto;
	}


	public void setMezzoTrasporto(MezzoTrasporto mezzoTrasporto) {
		this.mezzoTrasporto = mezzoTrasporto;
	}
	
	
	
}
