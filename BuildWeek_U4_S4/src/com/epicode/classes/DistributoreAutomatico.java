package com.epicode.classes;

import java.time.LocalDate;

import javax.persistence.*;

@Entity

public class DistributoreAutomatico extends RivenditoreAutorizzato{
	
private boolean attivo;

public DistributoreAutomatico() {}

public DistributoreAutomatico(int carteDaViaggioVendute, LocalDate dataEmissione, boolean attivo) {
	super(carteDaViaggioVendute, dataEmissione);
	this.attivo = attivo;
}

@Override
public String toString() {
	return "DistributoreAutomatico [attivo=" + attivo + "]";
}

public void stampaBiglietto() {
	if(attivo) {
		System.out.println("Biglietto stampato..");
	}else {
		System.out.println("Distributore Automatico fuori servizio!");
	}
}


}
