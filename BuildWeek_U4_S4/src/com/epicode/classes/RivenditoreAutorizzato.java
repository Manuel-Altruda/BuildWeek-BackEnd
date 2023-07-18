package com.epicode.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class RivenditoreAutorizzato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int carteDaViaggioVendute;
	private LocalDate dataEmissione;
	//protected boolean apertura;
	
	@OneToMany
	private List<CartaDaViaggio> lista = new ArrayList();

	public RivenditoreAutorizzato() {}

	public RivenditoreAutorizzato( LocalDate dataEmissione) {
		super();
		this.carteDaViaggioVendute = 0;
		this.dataEmissione = dataEmissione;
	}

	public long getId() {
		return id;
		
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCarteDaViaggioVendute() {
		return carteDaViaggioVendute;
	}

	public void setCarteDaViaggioVendute(int carteDaViaggioVendute) {
		this.carteDaViaggioVendute = carteDaViaggioVendute;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public List<CartaDaViaggio> getLista() {
		return lista;
	}

	public void setLista(List<CartaDaViaggio> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "RivenditoreAutorizzato [id=" + id + ", carteDaViaggioVendute=" + carteDaViaggioVendute
				+ ", dataEmissione=" + dataEmissione + ", lista=" + lista + "]";
	}
	
	
}
