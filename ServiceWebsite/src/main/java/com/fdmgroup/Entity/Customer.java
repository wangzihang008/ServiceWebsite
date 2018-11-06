package com.fdmgroup.Entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_website_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customer_id;
	private String username;
	private String password;
	private String email;
	private String status;
	private Calendar create_date_time;
	private Calendar last_log_date_time;
	private Calendar last_updated_time;
	private int vendor_id;
	
	
	public Customer() {
		super();
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Calendar getCreate_date_time() {
		return create_date_time;
	}
	public void setCreate_date_time(Calendar create_date_time) {
		this.create_date_time = create_date_time;
	}
	public Calendar getLast_log_date_time() {
		return last_log_date_time;
	}
	public void setLast_log_date_time(Calendar last_log_date_time) {
		this.last_log_date_time = last_log_date_time;
	}
	public Calendar getLast_updated_time() {
		return last_updated_time;
	}
	public void setLast_updated_time(Calendar last_updated_time) {
		this.last_updated_time = last_updated_time;
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create_date_time == null) ? 0 : create_date_time.hashCode());
		result = prime * result + customer_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((last_log_date_time == null) ? 0 : last_log_date_time.hashCode());
		result = prime * result + ((last_updated_time == null) ? 0 : last_updated_time.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + vendor_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (create_date_time == null) {
			if (other.create_date_time != null)
				return false;
		} else if (!create_date_time.equals(other.create_date_time))
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (last_log_date_time == null) {
			if (other.last_log_date_time != null)
				return false;
		} else if (!last_log_date_time.equals(other.last_log_date_time))
			return false;
		if (last_updated_time == null) {
			if (other.last_updated_time != null)
				return false;
		} else if (!last_updated_time.equals(other.last_updated_time))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (vendor_id != other.vendor_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", username=" + username + ", password=" + password + ", email="
				+ email + ", status=" + status + ", create_date_time=" + create_date_time + ", last_log_date_time="
				+ last_log_date_time + ", last_updated_time=" + last_updated_time + ", vendor_id=" + vendor_id + "]";
	}
	
	
	
	
}
