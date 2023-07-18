package com.epicode.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.epicode.classes.DistributoreAutomatico;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;


public class DistributoreAutomaticoDAO {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public DistributoreAutomaticoDAO() {
        emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
        em = emf.createEntityManager();
    }
	
	public List<DistributoreAutomatico> dataEmissione (LocalDate dataEmissione){
		
		@SuppressWarnings("unchecked")
		Query query = em.createQuery("SELECT de FROM DistributoreAutomatico de WHERE de.dataEmissione = :dataEmissione ", DistributoreAutomatico.class);
		query.setParameter("dataEmissione", dataEmissione);
		return query.getResultList();
		
	}
	
	public List<DistributoreAutomatico> acceso (boolean acceso){
		
		Query query = em.createQuery("SELECT d FROM DistributoreAutomatico d WHERE d.attivo = :acceso ", DistributoreAutomatico.class);
		query.setParameter("attivo", acceso);
		return query.getResultList();
		
	}
	


}
