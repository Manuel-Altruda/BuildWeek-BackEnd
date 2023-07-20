package com.epicode.DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.epicode.classes.MezzoTrasporto;
import com.epicode.classes.RottaStradale;
import com.epicode.classes.Tram;

public class RottaStradaleDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
	EntityManager em = emf.createEntityManager();

	public void saveRottaStradaleDAO(RottaStradale rotta) throws SQLException {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_U4_S4");
		EntityManager em = emf.createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(rotta);
            em.getTransaction().commit();
            System.out.println(rotta);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
		
	}
	
	public void deleteRottaStradaleDAO (long coordinateTratta) throws SQLException {
		em.getTransaction().begin();
		RottaStradale rotta = em.find(RottaStradale.class, coordinateTratta);
    	em.remove(rotta);
    	em.getTransaction().commit();
		System.out.println("Rotta stradale cancellata correttamente");	
	}
	
	public void getRottaStradaleDAO() throws SQLException {
		Query query = em.createQuery("SELECT rotta FROM RottaStradale", RottaStradale.class);
		List<RottaStradale> resultList = query.getResultList();
		resultList.forEach(e -> System.out.println(e));
	}
	
	public void findRottaStradaleDAO(long coordinateTratta) throws SQLException {
		em.getTransaction().begin();
		RottaStradale rotta = em.find(RottaStradale.class, coordinateTratta);
		em.getTransaction().commit();
		System.out.println(rotta);
	}
	
	public List<RottaStradale> findByZonaPartenza(String zonaPartenza) {
        return em.createQuery("SELECT rs FROM RottaStradale rs WHERE rs.zonaPartenza = :zonaPartenza", RottaStradale.class)
                .setParameter("zonaPartenza", zonaPartenza)
                .getResultList();
    }
	
	 public List<RottaStradale> findByCapolinea(String capolinea) {
	        return em.createQuery("SELECT rs FROM RottaStradale rs WHERE rs.capolinea = :capolinea", RottaStradale.class)
	                .setParameter("capolinea", capolinea)
	                .getResultList();
	    }
	 
	 public List<RottaStradale> findByMezzoTrasporto(MezzoTrasporto mezzoTrasporto) {
	        return em.createQuery("SELECT rs FROM RottaStradale rs WHERE rs.mezzoTrasporto = :mezzoTrasporto", RottaStradale.class)
	                .setParameter("mezzoTrasporto", mezzoTrasporto)
	                .getResultList();
	    }
	 
	 public int countRotteByMezzoTrasporto(MezzoTrasporto mezzoTrasporto) {
	        return em.createQuery("SELECT COUNT(rs) FROM RottaStradale rs WHERE rs.mezzoTrasporto = :mezzoTrasporto", Long.class)
	                .setParameter("mezzoTrasporto", mezzoTrasporto)
	                .getSingleResult()
	                .intValue();
	    }
	 
	public int tempoImpiegato(String zonaPartenza, String capolinea) throws SQLException {
		//bisogna trova un modo per reperire gli orari e sottrarli per avere l'effettiva durata
		try {
            List<RottaStradale> rotte = em.createQuery("SELECT rs FROM RottaStradale rs WHERE rs.zonaPartenza = :zonaPartenza AND rs.capolinea = :capolinea", RottaStradale.class)
                    .setParameter("zonaPartenza", zonaPartenza)
                    .setParameter("capolinea", capolinea)
                    .getResultList();

            if (rotte.isEmpty()) {
                throw new IllegalArgumentException("Non esiste una rotta tra la zona di partenza e il capolinea specificati.");
            }

            int tempoTotale = 0;
            for (RottaStradale rotta : rotte) {
                tempoTotale += rotta.getTempoMedioPercorrenza();
            }

            return tempoTotale;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Ritorna un valore negativo per indicare un errore o un'assenza di percorsi
        }
	}
	
	public static int countTimesTramOnRoute(Tram tram, RottaStradale tratta, LocalDate startDate, LocalDate endDate, EntityManager em) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(r) FROM RottaStradale r WHERE r.mezzoTrasporto = :tram AND r = :tratta AND r.dataPartenza BETWEEN :startDate AND :endDate", Long.class)
            .setParameter("tram", tram)
            .setParameter("tratta", tratta)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate);
        return query.getSingleResult().intValue();
    }
	
	public double avgTempoMedioPercorrenzaByMezzoTrasporto(MezzoTrasporto mezzoTrasporto) {
        return em.createQuery("SELECT AVG(rs.tempoMedioPercorrenza) FROM RottaStradale rs WHERE rs.mezzoTrasporto = :mezzoTrasporto", Double.class)
                .setParameter("mezzoTrasporto", mezzoTrasporto)
                .getSingleResult();
    }
}
