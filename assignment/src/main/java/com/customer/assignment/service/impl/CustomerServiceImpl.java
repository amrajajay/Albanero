package com.customer.assignment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.assignment.entity.Customer;
import com.customer.assignment.repository.CustomerRepository;
import com.customer.assignment.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int customer_id) {
		return customerRepository.findById(customer_id).orElse(null);
	}

	@Override
	public Customer addOrUpdateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer deleteCustomer(int customer_id) {
		Customer deletedCustomer = getCustomerById(customer_id);
		if (deletedCustomer != null)
			customerRepository.deleteById(customer_id);
		return deletedCustomer;
	}

	@Override
	public List<Customer> getUniqueColumnValues(String columnName) {

//		findAll().stream().collect(Collectors.groupingBy(Customer::getFirstName,Collectors.minBy(Comparator.comparingInt(Customer::getCustomerId)))).values().stream().collect(Collectors.toList());
		List<Customer> res = null;
		try {
			switch (columnName) {
			case "first_name":
				res = customerRepository.getUniqueFirstName();
				break;
			case "last_name":
				res = customerRepository.getUniqueLastName();
				break;
			case "address":
				res = customerRepository.getUniqueAddress();
				break;
			case "pincode":
				res = customerRepository.getUniquePincode();
				break;
			case "phone_number":
				res = customerRepository.getUniquePhoneNumber();
				break;
			case "customer_id":
				res = customerRepository.getUniqueCustomer_Id();
				break;
			case "city":
				res = customerRepository.getUniqueCity();
				break;

			case "created_on":
				res = customerRepository.getUniqueCreatedOn();
				break;
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public List groupByColumn(String inputColumn) {
		List res = null;

		try {
			switch (inputColumn) {
			case "first_name":
				res = customerRepository.findAll().stream().map(Customer::getFirstName).distinct()
						.collect(Collectors.toList());
				break;
			case "last_name":
				res = customerRepository.findAll().stream().map(Customer::getLastName).distinct()
						.collect(Collectors.toList());
				break;
			case "address":
				res = customerRepository.findAll().stream().map(Customer::getAddress).distinct()
						.collect(Collectors.toList());
				break;
			case "pincode":
				res = customerRepository.findAll().stream().map(Customer::getPincode).distinct()
						.collect(Collectors.toList());
				break;
			case "phone_number":
				res = customerRepository.findAll().stream().map(Customer::getPhoneNumber).distinct()
						.collect(Collectors.toList());
				break;
			case "customer_id":
				res = customerRepository.findAll().stream().map(Customer::getCustomerId).distinct()
						.collect(Collectors.toList());
				break;
			case "city":
				res = customerRepository.findAll().stream().map(Customer::getCity).distinct()
						.collect(Collectors.toList());
				break;

			case "created_on":
				res = customerRepository.findAll().stream().map(Customer::getCreated_on).distinct()
						.collect(Collectors.toList());
				break;
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;

	}
}
