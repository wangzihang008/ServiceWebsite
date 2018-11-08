package com.fdmgroup.Entity.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fdmgroup.Entity.Customer;

public class CustomerDao {
	private EntityManagerFactory emf;
	
	public CustomerDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	/**
	 * 
	 * @param id
	 * @return Customer object with the id
	 */
	public Customer get(long id) {
		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, id);
		em.close();
		return customer;
	}
	
	/**
	 * insert 1 customer record into database
	 * @param customer
	 */
	public void add(Customer customer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(customer);
		et.commit();
		em.close();
	}
	
	/**
	 * update record by given id with given customer object
	 * @param id
	 * @param customer
	 */
	public void update(long id, Customer customer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Customer old = em.find(Customer.class, id);
		old.setEmail(customer.getEmail());
		old.setUsername(customer.getUsername());
		old.setPassword(customer.getPassword());
		old.setStatus(customer.getStatus());
		old.setLast_updated_time(customer.getLast_updated_time());
		old.setLast_log_date_time(customer.getLast_log_date_time());
		old.setCreate_date_time(customer.getCreate_date_time());
		old.setVendor(customer.getVendor());
		et.commit();
		em.close();
	}

	/**
	 * delete record by id
	 * @param id
	 */
	public void delete(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
		et.commit();
		em.close();
		
	}
	
	public Customer getByUsernameAndPassword(String username, String password) {
		EntityManager em = emf.createEntityManager();
		Customer result = null;
		String queryStr = "SELECT c FROM Customer c WHERE c.username=:username and "
				+ "c.password=:password";
		TypedQuery<Customer> query = (TypedQuery<Customer>) em.createQuery(queryStr, Customer.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		ArrayList<Customer> resultList = (ArrayList<Customer>) query.getResultList();
		if(resultList.size() == 1) {
			result = resultList.get(0);
		}
		em.close();
		return result;
	}
}
