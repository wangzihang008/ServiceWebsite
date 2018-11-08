package com.fdmgroup.ServiceWebsite;

import java.util.Calendar;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.util.UserDataAttribute;

import com.fdmgroup.Entity.Administrator;
import com.fdmgroup.Entity.Customer;
import com.fdmgroup.Entity.Vendor;
import com.fdmgroup.Entity.Dao.AdministratorDao;
import com.fdmgroup.Entity.Dao.CustomerDao;
import com.fdmgroup.Entity.Dao.Dao;
import com.fdmgroup.Entity.Dao.VendorDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("EMF");
    	Dao dao = new Dao(emf);
    	
    	// Create administrator table and add 1 record
//        AdministratorDao ad = new AdministratorDao(emf);
//        Administrator admin = new Administrator("admin_robertwang", DigestUtils.md5Hex("admin"), "robert", "wang", "active");
//        ad.add(admin);
    	
    	// Create User table and add 2 users
    	CustomerDao cd = new CustomerDao(emf);
    	Calendar calendar = Calendar.getInstance();
    	Customer customer1 = new Customer("robertwang", DigestUtils.md5Hex("rt2018"), "robert.wang@fdmgroup.com",
    			"active", calendar, calendar, calendar);
    	Customer customer2 = new Customer("bobliang", DigestUtils.md5Hex("bl2018"), "bob.liang@fdmgroup.com",
    			"active", calendar, calendar, calendar);
    	cd.add(customer1);
    	cd.add(customer2);
    	
    	VendorDao vd = new VendorDao(emf);
    	Vendor vendor = new Vendor(0, "Shanghai", "18181188188", "active", "robert", "", "wang", "robert's store", "robert_store");
//    	vd.add(vendor);
    	
    	customer1 = cd.getByUsernameAndPassword("robertwang", DigestUtils.md5Hex("rt2018"));
    	vendor.setCustomer(customer1);
    	customer1.setVendor(vendor);
    	cd.update(customer1.getCustomer_id(), customer1);
    }
}
