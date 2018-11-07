package com.fdmgroup.Entity.Dao;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.Entity.Customer;

public class DaoTest {
	@Test
	public void Given_Dao_WhenExcuteQuery_ReturnListOfObjectsAndCleansUpRecourses() {
		EntityManagerFactory EMF = mock(EntityManagerFactory.class);
		EntityManager EM = mock(EntityManager.class);
		Customer customer = mock(Customer.class);
		Query query = mock(Query.class);
		String querystr = "select e from customer e";
		
		when(EMF.createEntityManager()).thenReturn(EM);
		when(EM.createQuery(querystr)).thenReturn(query);
		
		Dao dao = new Dao(EMF);
		dao.excuteQuery(customer, querystr);
		
		InOrder order = inOrder(EMF, EM, query);
		order.verify(EMF).createEntityManager();
		order.verify(EM).createQuery(querystr);
		order.verify(query).getResultList();
		order.verify(EM).close();
	}
}
