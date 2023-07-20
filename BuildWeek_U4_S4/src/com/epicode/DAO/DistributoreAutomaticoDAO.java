package com.epicode.DAO;

import com.epicode.classes.CartaDaViaggio;
import com.epicode.classes.DistributoreAutomatico;

import java.sql.SQLException;
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
		
		Query query = em.createQuery("SELECT de FROM DistributoreAutomatico de WHERE de.dataEmissione = :dataEmissione ", DistributoreAutomatico.class);
		query.setParameter("dataEmissione", dataEmissione);
		return query.getResultList();
		
	}
	
	public List<DistributoreAutomatico> acceso (boolean acceso){
		
		Query query = em.createQuery("SELECT d FROM DistributoreAutomatico d WHERE d.attivo = :acceso ", DistributoreAutomatico.class);
		query.setParameter("attivo", acceso);
		return query.getResultList();
		
	}
	
	public void saveDistributoreAutomatic(DistributoreAutomatico c) throws SQLException {	

		em.getTransaction().begin();
    	em.persist(c);
    	em.getTransaction().commit();
    	System.out.println(c);
		
	}
	
	public void deleteDistributoreAutomatic (long id) throws SQLException {
			
			em.getTransaction().begin();
			DistributoreAutomatico carta = em.find(DistributoreAutomatico.class, id);
	    	em.remove(carta);
	    	em.getTransaction().commit();
			System.out.println("DistributoreAutomatico cancellato correttamente");
			
		}
	
	public void getAllDistributoreAutomatic() throws SQLException {
			
			Query query = em.createQuery("SELECT d FROM DistributoreAutomatico", DistributoreAutomatico.class);
			List<CartaDaViaggio> resultList = query.getResultList();
			resultList.forEach(e -> System.out.println(e));
			
		}
	
	public void findDistributoreAutomatic(long id) throws SQLException {
		
		em.getTransaction().begin();
		DistributoreAutomatico carta = em.find(DistributoreAutomatico.class, id);
		em.getTransaction().commit();
		System.out.println(carta);
		
	}
	
}