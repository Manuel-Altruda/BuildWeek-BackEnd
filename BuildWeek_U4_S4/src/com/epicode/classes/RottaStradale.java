package com.epicode.classes;

import java.time.LocalDate;

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
	private LocalDate orarioPartenza;
	private LocalDate orarioArrivo;
	
	@ManyToOne
	private MezzoTrasporto mezzoTrasporto;
	
	
	
	public RottaStradale(long coordinateTratta, String zonaPartenza, String capolinea, int tempoMedioPercorrenza,
			LocalDate orarioPartenza, LocalDate orarioArrivo, MezzoTrasporto mezzoTrasporto) {
		super();
		this.coordinateTratta = coordinateTratta;
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
		this.tempoMedioPercorrenza = tempoMedioPercorrenza;
		this.orarioPartenza = orarioPartenza;
		this.orarioArrivo = orarioArrivo;
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

	public LocalDate getOrarioPartenza() {
		return orarioPartenza;
	}

	public void setOrarioPartenza(LocalDate orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}

	public LocalDate getOrarioArrivo() {
		return orarioArrivo;
	}

	public void setOrarioArrivo(LocalDate orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
	}

	public MezzoTrasporto getMezzoTrasporto() {
		return mezzoTrasporto;
	}

	public void setMezzoTrasporto(MezzoTrasporto mezzoTrasporto) {
		this.mezzoTrasporto = mezzoTrasporto;
	}

	@Override
	public String toString() {
		return "RottaStradale [coordinateTratta=" + coordinateTratta + ", zonaPartenza=" + zonaPartenza + ", capolinea="
				+ capolinea + ", orarioPartenza=" + orarioPartenza + ", mezzoTrasporto=" + mezzoTrasporto + "]";
	}

	public String getIdRotta() {
		return getIdRotta();
	}
	
	
}
