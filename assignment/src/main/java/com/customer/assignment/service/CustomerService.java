package com.customer.assignment.service;

import java.util.List;

import com.customer.assignment.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int customer_id);
	public Customer addOrUpdateCustomer(Customer customer);
	public Customer deleteCustomer(int customer_id);
	public List<?> getUniqueColumnValues(String columnName);
	List<Customer> groupByColumn(String inputColumn);

}
