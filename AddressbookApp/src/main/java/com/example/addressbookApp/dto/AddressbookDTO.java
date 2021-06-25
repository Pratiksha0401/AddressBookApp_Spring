package com.example.addressbookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressbookDTO {
	public String firstName;
	public String lastName;
	public String address;

	
}
