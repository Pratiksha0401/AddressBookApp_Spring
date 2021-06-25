package com.example.addressbookApp.model;

import com.example.addressbookApp.dto.AddressbookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AddressbookData {
	
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	
	public AddressbookData(int id, AddressbookDTO addressbookDTO) {
		this.id = id;
		this.firstName = addressbookDTO.firstName;
		this.lastName = addressbookDTO.lastName;
		this.address = addressbookDTO.address;
	}
	
}
