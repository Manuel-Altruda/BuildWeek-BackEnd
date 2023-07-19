package com.epicode.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Utente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
protected long id;

protected String nome;
protected String cognome;


//OneToOne
// Tessera
@OneToOne(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
protected Tessera tessera;

//OneToMany
//Lista Biglietti
@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
protected List<Biglietto> listaBiglietti = new ArrayList<>();

// Costruttore vuoto
public Utente() {}

// Costruttore con nome e cognome
public Utente(String nome, String cognome) {
	this.nome = nome;
	this.cognome = cognome;
}

public long getId() {
    return id;
}

// Metodi Get di nome e cognome
public String getNome() {
	return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
    this.cognome = cognome;
}

public Tessera getTessera() {
    return tessera;
}

public void setTessera(Tessera tessera) {
    this.tessera = tessera;
}

public List<Biglietto> getListaBiglietti() {
    return listaBiglietti;
}

public void setListaBiglietti(List<Biglietto> listaBiglietti) {
    this.listaBiglietti = listaBiglietti;
}

// Metodo toString
@Override
public String toString() {
	return "Utente [nome= " + nome + ", cognome= " + cognome + "]";
}



}