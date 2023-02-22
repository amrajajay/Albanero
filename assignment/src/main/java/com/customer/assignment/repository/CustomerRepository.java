package com.customer.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.assignment.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	
	
	@Query(value = "SELECT * FROM customer WHERE (first_name, customer_id) IN (SELECT first_name, MIN(customer_id) FROM customer GROUP BY first_name)", nativeQuery = true)
	public List<Customer> getUniqueFirstName();

	@Query(value = "SELECT * FROM customer WHERE (last_name, customer_id) IN (SELECT last_name, MIN(customer_id) FROM customer GROUP BY last_name)", nativeQuery = true)
	public List<Customer> getUniqueLastName();

	@Query(value = "SELECT * FROM customer WHERE (address, customer_id) IN (SELECT address, MIN(customer_id) FROM customer GROUP BY address)", nativeQuery = true)
	public List<Customer> getUniqueAddress();

	@Query(value = "SELECT * FROM customer WHERE (address, customer_id) IN (SELECT address, MIN(customer_id) FROM customer GROUP BY address)", nativeQuery = true)
	public List<Customer> getUniquePincode();

	@Query(value = "SELECT * FROM customer WHERE (phone_number, customer_id) IN (SELECT phone_number, MIN(customer_id) FROM customer GROUP BY phone_number)", nativeQuery = true)
	public List<Customer> getUniquePhoneNumber();

	@Query(value = "SELECT * FROM customer WHERE (customer_id, customer_id) IN (SELECT customer_id, MIN(customer_id) FROM customer GROUP BY customer_id)", nativeQuery = true)
	public List<Customer> getUniqueCustomer_Id();

	@Query(value = "SELECT * FROM customer WHERE (city, customer_id) IN (SELECT city, MIN(customer_id) FROM customer GROUP BY city)", nativeQuery = true)
	public List<Customer> getUniqueCity();

	@Query(value = "SELECT * FROM customer WHERE (created_on, customer_id) IN (SELECT created_on, MIN(customer_id) FROM customer GROUP BY created_on)", nativeQuery = true)
	public List<Customer> getUniqueCreatedOn();

}
