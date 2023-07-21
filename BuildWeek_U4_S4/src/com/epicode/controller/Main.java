package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epicode.DAO.*;
import com.epicode.classes.Abbonamento;
import com.epicode.classes.Autobus;
import com.epicode.classes.Biglietto;
import com.epicode.classes.RivenditoreAutorizzato;
import com.epicode.classes.RottaStradale;
import com.epicode.classes.Tessera;
import com.epicode.classes.Tram;
import com.epicode.classes.Utente;
import com.epicode.enums.Periodicita;
import com.epicode.enums.Stato;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;




public class Main {

    public static void main(String[] args) throws SQLException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            
            RivenditoreAutorizzatoDAO rivenditoreAutorizzatoDAO = new RivenditoreAutorizzatoDAO();
            UtenteDAO utenteDAO = new UtenteDAO();
            CartaDaViaggioDAO cartaDaViaggioDAO = new CartaDaViaggioDAO();
            RottaStradaleDAO rottaStradaleDAO = new RottaStradaleDAO();

            RivenditoreAutorizzato r1 = new RivenditoreAutorizzato(200, LocalDate.of(2023, 7, 18));
            RivenditoreAutorizzato r2 = new RivenditoreAutorizzato(50, LocalDate.of(2022, 6, 19));
            
            RottaStradale rt1 = new RottaStradale();
            rottaStradaleDAO.saveRottaStradaleDAO(rt1);
            
            Utente utente1 = new Utente("Marco", "Sossi");
            Utente utente2 = new Utente("Marie", "Cossa");

            Biglietto b1 = new Biglietto(LocalDate.of(2023, 9, 10), r1, true, utente1);
            Biglietto b2 = new Biglietto(LocalDate.of(2023, 10, 11), r2, false, utente2);

            rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r1);
            rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r2);

            utenteDAO.saveUser(utente1);
            utenteDAO.saveUser(utente2);
            //utenteDAO.deleteUser(2);

            RivenditoreAutorizzato r3 = new RivenditoreAutorizzato(120, LocalDate.of(2023, 7, 18));
            RivenditoreAutorizzato r4 = new RivenditoreAutorizzato(150, LocalDate.of(2022, 6, 19));

            Utente utente3 = new Utente("Mariaca", "Sossialla");
            Utente utente4 = new Utente("Maridell", "Cuozzamma");

            Biglietto b3 = new Biglietto(LocalDate.of(2020, 5, 11), r3, true, utente3);
            Biglietto b4 = new Biglietto(LocalDate.of(2021, 11, 12), r4, false, utente4);

            rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r3);
            rivenditoreAutorizzatoDAO.saveRivenditoreAutorizzato(r4);

            utenteDAO.saveUser(utente3);
            utenteDAO.saveUser(utente4);

            cartaDaViaggioDAO.saveCartaDaViaggio(b1);
            cartaDaViaggioDAO.saveCartaDaViaggio(b2);

            cartaDaViaggioDAO.saveCartaDaViaggio(b3);
            cartaDaViaggioDAO.saveCartaDaViaggio(b4);

            //utenteDAO.deleteUser(2);

            Biglietto b5 = new Biglietto();
            b5.setDataEmissione(LocalDate.of(2023, 2, 12));

            cartaDaViaggioDAO.getByDate(LocalDate.of(2021, 7, 18), LocalDate.of(2024, 5, 18), r1);

            Utente utente = new Utente("Marcio", "Giordania");
            Tessera tessera1 = null;
            utente.setTessera(tessera1);
            utenteDAO.saveUser(utente);

            AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
            Abbonamento a1 = new Abbonamento(Periodicita.SETTIMANALE, LocalDate.now().plusDays(7), utente1);
            abbonamentoDAO.saveAbbonamento(a1);

            Abbonamento a2 = new Abbonamento(Periodicita.MENSILE, LocalDate.now().plusDays(7), utente2);
            abbonamentoDAO.saveAbbonamento(a2);

            TesseraDAO tesseraDAO = new TesseraDAO();
            Tessera tessera = new Tessera(LocalDate.now());
            tesseraDAO.saveTessera(tessera);

            MezzoTrasportoDAO mezzoTrasportoDAO = new MezzoTrasportoDAO();
            Tram tram = new Tram();
            tram.setCapienzaPersone(50);
            tram.setStato(Stato.SERVIZIO);
            tram.setTarga((long) 178625L);
            mezzoTrasportoDAO.saveMezzoDiTrasportoDAO(tram);
            
            Tram tram1 = new Tram();
            tram1.setCapienzaPersone(50);
            tram1.setStato(Stato.SERVIZIO);
            tram1.setTarga((long) 124525L);
            mezzoTrasportoDAO.saveMezzoDiTrasportoDAO(tram1);

            Autobus autobus = new Autobus();
            autobus.setCapienzaPersone(50);
            autobus.setStato(Stato.SERVIZIO);
            autobus.setTarga((long) 178625);
            mezzoTrasportoDAO.saveMezzoDiTrasportoDAO(autobus);

            LocalDate dataPartenza = LocalDate.of(2023, 1, 1);
            LocalDate endDate = LocalDate.of(2023, 12, 31);
            long startTimeStamp = dataPartenza.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
            long endTimeStamp = endDate.atTime(LocalTime.MAX).toEpochSecond(ZoneOffset.UTC);
            

            // Metodo per il conteggio delle vendite totali di biglietti e abbonamenti in un dato periodo di tempo
            long totalSales = BigliettoDAO.countTotalSales(dataPartenza, endDate, em) + AbbonamentoDAO.countVenditeTotaliAbbonamento(dataPartenza, endDate, em);
            System.out.println("Totale vendite nel periodo: " + totalSales);

            
            
            
            // Metodo per il conteggio delle vendite totali di biglietti e abbonamenti per un punto di emissione in un dato periodo di tempo
            RivenditoreAutorizzato rivenditore = em.find(RivenditoreAutorizzato.class, 1L);
            long salesForRivenditore = BigliettoDAO.countSalesForRivenditore(rivenditore, dataPartenza, endDate, em) + AbbonamentoDAO.countVenditeRivenditore(rivenditore, dataPartenza, endDate, em);
            System.out.println("Vendite per il punto di emissione " + rivenditore.getLista() + ": " + salesForRivenditore);

            
            
            
            // Metodo per il conteggio delle volte che un mezzo ha percorso una tratta in un dato periodo di tempo
             tram1 = em.find(Tram.class, 124525L);
            //RottaStradale tratta = em.find(RottaStradale.class, 1L);
            long timesTramOnRoute = RottaStradaleDAO.countTimesTramOnRoute(tram, rt1, startTimeStamp, endTimeStamp, em);
            System.out.println("Tram " + tram1.getTarga() + " percorso la tratta " + rt1.getCoordinateTratta() + " " + timesTramOnRoute + " volte.");

            
            
            
            
            // Metodo per verificare la validità di un abbonamento in base al numero di tessera dell'utente
            Utente utenteDaControllare = em.find(Utente.class, 1L);
            boolean isAbbonamentoValido = UtenteDAO.checkAbbonamentoValidita(utenteDaControllare, em);
            System.out.println("L'abbonamento dell'utente " + utenteDaControllare.getId() + " è valido? " + isAbbonamentoValido);
        
        
        
        
        } finally {
            tx.commit();
            em.close();
            emf.close();
        }
    }
}


