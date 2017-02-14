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
 * @author simone
 */
public class ServersJpaController implements Serializable {

	public ServersJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}
	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Servers servers) throws PreexistingEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(servers);
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (findServers(servers.getId()) != null) {
				throw new PreexistingEntityException("Servers " + servers + " already exists.", ex);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Servers servers) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			servers = em.merge(servers);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = servers.getId();
				if (findServers(id) == null) {
					throw new NonexistentEntityException("The servers with id " + id + " no longer exists.");
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
			Servers servers;
			try {
				servers = em.getReference(Servers.class, id);
				servers.getId();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The servers with id " + id + " no longer exists.", enfe);
			}
			em.remove(servers);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Servers> findServersEntities() {
		return findServersEntities(true, -1, -1);
	}

	public List<Servers> findServersEntities(int maxResults, int firstResult) {
		return findServersEntities(false, maxResults, firstResult);
	}

	private List<Servers> findServersEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Servers.class));
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

	public Servers findServers(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Servers.class, id);
		} finally {
			em.close();
		}
	}

	public int getServersCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Servers> rt = cq.from(Servers.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}
	
}
