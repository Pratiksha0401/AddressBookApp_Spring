package com.example.addressbookApp.dto;

public class AddressbookDTO {
	public String firstName;
	public String lastName;
	public String address;
	
	public AddressbookDTO() {
	}

	public AddressbookDTO(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddressbookDTO [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
	
}
