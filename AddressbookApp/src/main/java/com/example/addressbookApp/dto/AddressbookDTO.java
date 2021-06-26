package com.example.addressbookApp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressbookDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z\\s]{2,}$", message = "Employee First Name Invalid")
	public String name;
	
	@NotBlank(message = "Address cannot be null")
	public String address;
	
	public String city;
	
	public String state;
	
	public int zipcode;
	
	@Pattern(regexp = "^[+]{0,1}[0-9]{2}\\s{0,1}[1-9]{1}[0-9]{9}$", message = "PhoneNumber Invalid")
	public String phonenumber;

	
}
