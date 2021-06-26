package com.example.addressbookApp.model;

import com.example.addressbookApp.dto.AddressbookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AddressbookData {
	
	private int id;
	private String name;
	private String address;
	public String city;	
	public String state;		
	public int zipcode;		
	public String phonenumber;
	
	public AddressbookData(int id, AddressbookDTO addressbookDTO) {
		this.id = id;
		this.name = addressbookDTO.name;
		this.address = addressbookDTO.address;
		this.city = addressbookDTO.city;
		this.state = addressbookDTO.state;
		this.zipcode = addressbookDTO.zipcode;
		this.phonenumber = addressbookDTO.phonenumber;
	}
	
}
