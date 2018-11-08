package com.fdmgroup.Entity.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class Dao {

	private EntityManagerFactory emf;

	public Dao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List excuteQuery(Object object, String query) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(query, object.getClass());
		List resultList = q.getResultList();
		em.close();
		return resultList;
	}
	
}
