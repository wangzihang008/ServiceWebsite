package com.fdmgroup.Entity.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class AdministratorDao {

	private EntityManagerFactory emf;

	public AdministratorDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List getAdministrator(String username, String password) {
		EntityManager em = emf.createEntityManager();
		String queryStr = "select e.admin_id, e.status, e.first_name, e.last_name from admin e "
				+ "where e.username = '" + username + "' and e.password = '" + password + "'";
		Query query = em.createQuery(queryStr);
		List resultList = query.getResultList();
		em.close();
		return resultList;
		
	}
	
}
 