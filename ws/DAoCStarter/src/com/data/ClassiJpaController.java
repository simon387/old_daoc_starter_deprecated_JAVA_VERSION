/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.data.exceptions.NonexistentEntityException;
import com.data.exceptions.PreexistingEntityException;
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
public class ClassiJpaController implements Serializable {

    public ClassiJpaController(EntityManagerFactory emf) {
	this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
	return emf.createEntityManager();
    }

    public void create(Classi classi) throws PreexistingEntityException, Exception {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    em.persist(classi);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    if (findClassi(classi.getId()) != null) {
		throw new PreexistingEntityException("Classi " + classi + " already exists.", ex);
	    }
	    throw ex;
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public void edit(Classi classi) throws NonexistentEntityException, Exception {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    classi = em.merge(classi);
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    String msg = ex.getLocalizedMessage();
	    if (msg == null || msg.length() == 0) {
		Integer id = classi.getId();
		if (findClassi(id) == null) {
		    throw new NonexistentEntityException("The classi with id " + id + " no longer exists.");
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
	    Classi classi;
	    try {
		classi = em.getReference(Classi.class, id);
		classi.getId();
	    } catch (EntityNotFoundException enfe) {
		throw new NonexistentEntityException("The classi with id " + id + " no longer exists.", enfe);
	    }
	    em.remove(classi);
	    em.getTransaction().commit();
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public List<Classi> findClassiEntities() {
	return findClassiEntities(true, -1, -1);
    }

    public List<Classi> findClassiEntities(int maxResults, int firstResult) {
	return findClassiEntities(false, maxResults, firstResult);
    }

    private List<Classi> findClassiEntities(boolean all, int maxResults, int firstResult) {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(Classi.class));
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

    public Classi findClassi(Integer id) {
	EntityManager em = getEntityManager();
	try {
	    return em.find(Classi.class, id);
	} finally {
	    em.close();
	}
    }

    public int getClassiCount() {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    Root<Classi> rt = cq.from(Classi.class);
	    cq.select(em.getCriteriaBuilder().count(rt));
	    Query q = em.createQuery(cq);
	    return ((Long) q.getSingleResult()).intValue();
	} finally {
	    em.close();
	}
    }
    
}
