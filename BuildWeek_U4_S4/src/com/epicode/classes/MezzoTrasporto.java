package com.epicode.classes;

import java.time.LocalDate;

import com.epicode.enums.Stato;

import jakarta.persistence.*;

@Entity
public abstract class MezzoTrasporto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private int capienzaPersone;
	
	@Enumerated(EnumType.STRING)
    private Stato stato;
	
	private LocalDate inizioServizio;
	private LocalDate fineServizio;
	private LocalDate inizioManutenzione;
	private LocalDate fineManutenzione;
	private boolean validazione;
	
	
	public MezzoTrasporto() {}

    public long getId() {
        return id;
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
    }
}
