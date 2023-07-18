package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Tessera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	private LocalDate dataAttivazione;
	private LocalDate dataScadenza;
	private boolean validita;
	
	@OneToOne
	private Utente utente;

	public Tessera(LocalDate dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
		this.dataScadenza = dataAttivazione.plusDays(365);
		this.validita = true;
	}
	
	public Tessera() {}
	
	public long getId() {
        return id;
    }

	public LocalDate getDataAttivazione() {
		return dataAttivazione;
	}

	public void setDataAttivazione(LocalDate dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public boolean isValidita() {
		return validita;
	}

	public void setValidita(boolean validita) {
		this.validita = validita;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Tessera [id=" + id + ", dataAttivazione=" + dataAttivazione + ", dataScadenza=" + dataScadenza
				+ ", validita=" + validita + ", utente=" + utente + "]";
	}
		
}
