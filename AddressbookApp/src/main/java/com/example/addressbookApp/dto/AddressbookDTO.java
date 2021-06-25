package com.example.addressbookApp.dto;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressbookDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z\\s]{2,}$", message = "Employee First Name Invalid")
	public String name;
	
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z\\s]{2,}$", message = "Address cannot be empty")
	public String address;

	
}
