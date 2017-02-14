/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.data.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Simone
 */
public class ToonJpaController implements Serializable {

    public ToonJpaController(EntityManagerFactory emf) {
	this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
	return emf.createEntityManager();
    }

    public void create(Toon toon) {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    em.persist(toon);
	    em.getTransaction().commit();
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public void edit(Toon toon) throws NonexistentEntityException, Exception {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    toon = em.merge(toon);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    String msg = ex.getLocalizedMessage();
	    if (msg == null || msg.length() == 0) {
		Integer id = toon.getId();
		if (findToon(id) == null) {
		    throw new NonexistentEntityException("The toon with id " + id + " no longer exists.");
		}
	    }
	    throw ex;
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public void destroy(Integer id) throws NonexistentEntityException {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    Toon toon;
	    try {
		toon = em.getReference(Toon.class, id);
		toon.getId();
	    } catch (EntityNotFoundException enfe) {
		throw new NonexistentEntityException("The toon with id " + id + " no longer exists.", enfe);
	    }
	    em.remove(toon);
	    em.getTransaction().commit();
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public List<Toon> findToonEntities() {
	return findToonEntities(true, -1, -1);
    }

    public List<Toon> findToonEntities(int maxResults, int firstResult) {
	return findToonEntities(false, maxResults, firstResult);
    }

    private List<Toon> findToonEntities(boolean all, int maxResults, int firstResult) {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(Toon.class));
	    Query q = em.createQuery(cq);
	    if (!all) {
		q.setMaxResults(maxResults);
		q.setFirstResult(firstResult);
	    }
	    return q.getResultList();
	} finally {
	    em.close();
	}
    }

    public Toon findToon(Integer id) {
	EntityManager em = getEntityManager();
	try {
	    return em.find(Toon.class, id);
	} finally {
	    em.close();
	}
    }

    public int getToonCount() {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    Root<Toon> rt = cq.from(Toon.class);
	    cq.select(em.getCriteriaBuilder().count(rt));
	    Query q = em.createQuery(cq);
	    return ((Long) q.getSingleResult()).intValue();
	} finally {
	    em.close();
	}
    }
}
