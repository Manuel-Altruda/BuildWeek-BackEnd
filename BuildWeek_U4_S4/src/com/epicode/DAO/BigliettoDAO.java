package com.epicode.DAO;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.epicode.classes.RivenditoreAutorizzato;

public class BigliettoDAO {
	public static long countTotalSales(LocalDate startDate, LocalDate endDate, EntityManager em) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :startDate AND :endDate", Long.class)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate);
        return query.getSingleResult();
    }

    public static long countSalesForRivenditore(RivenditoreAutorizzato rivenditore, LocalDate startDate, LocalDate endDate, EntityManager em) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.rivenditoreAutorizzato = :rivenditore AND b.dataEmissione BETWEEN :startDate AND :endDate", Long.class)
            .setParameter("rivenditore", rivenditore)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate);
        return query.getSingleResult();
    }
}
