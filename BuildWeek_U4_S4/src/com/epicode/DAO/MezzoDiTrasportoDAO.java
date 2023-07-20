package com.epicode.DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.classes.MezzoTrasporto;
import com.epicode.enums.Stato;

public class MezzoDiTrasportoDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
	EntityManager em = emf.createEntityManager();

	public void saveMezzoDiTrasportoDAO(MezzoTrasporto mt) throws SQLException {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
		EntityManager em = emf.createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(mt);
            em.getTransaction().commit();
            System.out.println(mt);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
		
	}
	
	public void deleteMezzoDiTrasportoDAO (long id) throws SQLException {
			
			em.getTransaction().begin();
			MezzoTrasporto carta = em.find(MezzoTrasporto.class, id);
	    	em.remove(carta);
	    	em.getTransaction().commit();
			System.out.println("Carta da viaggio cancellato correttamente");
			
		}
	
	public void getMezzoDiTrasporto() throws SQLException {
			
			Query query = em.createQuery("SELECT mt FROM MezzoTrasporto", MezzoTrasporto.class);
			List<MezzoTrasporto> resultList = query.getResultList();
			resultList.forEach(e -> System.out.println(e));
			
		}
	
	public void findMezzoDiTrasporto(long id) throws SQLException {
		
		em.getTransaction().begin();
		MezzoTrasporto carta = em.find(MezzoTrasporto.class, id);
		em.getTransaction().commit();
		System.out.println(carta);
		
	}
	
	public List<MezzoTrasporto> findStato(Stato stato) {
		return em.createQuery("SELECT mt FROM MezzoTrasporto mt WHERE mt.stato = :stato", MezzoTrasporto.class)
				.setParameter("stato", stato)
				.getResultList();
		}
	
	public List<MezzoTrasporto> findInServizio(LocalDate data) {
		return em.createQuery("SELECT mt FROM MezzoTrasporto mt WHERE mt.inizioServizio <= :data AND mt.fineServizio >= :data", MezzoTrasporto.class)
				.setParameter("data", data)
				.getResultList();
	}
	
	public List<MezzoTrasporto> findInManutenzione(LocalDate data) {
		return em.createQuery("SELECT mt FROM MezzoTrasporto mt WHERE mt.inizioManutenzione <= :data AND mt.fineManutenzione >= :data", MezzoTrasporto.class)
				.setParameter("data", data)
				.getResultList();
	}

}

