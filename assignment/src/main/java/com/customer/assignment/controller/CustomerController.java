package com.customer.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.assignment.entity.Customer;
import com.customer.assignment.exception.CustomerNotFoundException;
import com.customer.assignment.exception.ValidationError;
import com.customer.assignment.exception.ValidationErrorResponse;
import com.customer.assignment.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		if (customers.isEmpty())
			throw new CustomerNotFoundException("Records not available");
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);

	}

	@GetMapping("/getById/{customer_id}")
	public ResponseEntity<Customer> getCustomersById(@PathVariable("customer_id") int id) {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null)
			throw new CustomerNotFoundException("Id  not available in records");
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@PostMapping("/addOrUpdateCustomer")
	public ResponseEntity<?> addOrUpdate(@Valid @RequestBody Customer requestCustomer, BindingResult result) {
		if (result.hasErrors()) {
			List<ValidationError> errors = result.getAllErrors().stream()
					.map(error -> new ValidationError(((FieldError) error).getField(), error.getDefaultMessage()))
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(new ValidationErrorResponse(errors));
		}
		Customer customer = customerService.addOrUpdateCustomer(requestCustomer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@DeleteMapping("/deleteById/{customer_id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customer_id") int id) throws Exception {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Id not available in records");
		}
		customer = customerService.deleteCustomer(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/getByColumnName/{columnname}")
	public ResponseEntity<List> distinctColumnValues(@PathVariable("columnname") String columnName) throws Exception {
		List customers = customerService.getUniqueColumnValues(columnName);
		if (customers == null)
			throw new CustomerNotFoundException("Column not available");
		return new ResponseEntity<List>(customers, HttpStatus.OK);

	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/getGroupByColumn/{inputColumn}")
	public ResponseEntity<List> groupByColumn(@PathVariable String inputColumn) throws Exception {
		List<Customer> groupedData = customerService.groupByColumn(inputColumn);
		if (groupedData == null)
			throw new CustomerNotFoundException("Column not available");
		return new ResponseEntity<List>(groupedData, HttpStatus.OK);
	}

}
