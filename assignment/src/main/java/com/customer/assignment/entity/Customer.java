package com.customer.assignment.entity;

import java.time.LocalDateTime;
import java.lang.Integer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer")
public class Customer {

	@Column(name = "first_name")
	@NotBlank(message = "First name cannot be blank")
	@NotNull(message = "First name cannot be null")
	private String firstName;

	@Column(name = "lastName")
	@NotBlank(message = "Last name cannot be blank")
	@NotNull(message = "Last name cannot be null")
	private String lastName;

	@Column(name = "address")
	@NotBlank(message = "Address cannot be blank")
	@NotNull(message = "Address cannot be null")
	private String address;

	@Column(name = "pincode")
	@Pattern(regexp = "^[0-9]{6}$", message = "Length of pincode should be 6")
	private String pincode;

	@Column(name = "phone_number")
	@Pattern(regexp = "^\\+?[0-9]{10,12}$", message = "Invaild Phone number")
	@NotNull(message = "Phone Number cannot be null")
	private String phoneNumber;

	@Id
	@Min(1)
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "city")
	@NotBlank(message = "City cannot be blank")
	@NotNull(message = "City cannot be null")
	private String city;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime created_on;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public Customer(
			@NotBlank(message = "First name cannot be blank") @NotNull(message = "First name cannot be null") String firstName,
			@NotBlank(message = "Last name cannot be blank") @NotNull(message = "Last name cannot be null") String lastName,
			@NotBlank(message = "Address cannot be blank") @NotNull(message = "Address cannot be null") String address,
			@Pattern(regexp = "^[0-9]{6}$", message = "Length of pincode should be 6") String pincode,
			@Pattern(regexp = "^\\+?[0-9]{10,12}$", message = "Invaild Phone number") @NotNull(message = "Phone Number cannot be null") String phoneNumber,
			@Min(1) int customerId,
			@NotBlank(message = "City cannot be blank") @NotNull(message = "City cannot be null") String city,
			LocalDateTime created_on) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
		this.customerId = customerId;
		this.city = city;
		this.created_on = created_on;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", pincode="
				+ pincode + ", phoneNumber=" + phoneNumber + ", customerId=" + customerId + ", city=" + city
				+ ", created_on=" + created_on + "]";
	}

}
