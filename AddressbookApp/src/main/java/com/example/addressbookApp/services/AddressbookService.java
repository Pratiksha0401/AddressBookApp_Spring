package com.example.addressbookApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.addressbookApp.dto.AddressbookDTO;
import com.example.addressbookApp.model.AddressbookData;

@Service
public class AddressbookService implements IAddessbookService{

	@Override
	public List<AddressbookData> getAddressbookData() {
		List<AddressbookData> bookDataList = new ArrayList<>();
		bookDataList.add(new AddressbookData(1,new AddressbookDTO("Pratiksha","Nagoshe","Bhandara")));
		return bookDataList;
	}

	@Override
	public AddressbookData getAddressbookDataById(int id) {
		AddressbookData bookData = null;
		bookData=new AddressbookData(1,new AddressbookDTO("Pratiksha","Nagoshe","Bhandara"));
		return bookData;
	}

	@Override
	public AddressbookData createAddressbookData(AddressbookDTO bookDTO) {
		AddressbookData personData = null;
		personData=new AddressbookData(1, bookDTO);
		return personData;
	}
	
	@Override
	public AddressbookData updateAddressbookData(AddressbookDTO bookDTO) {
		AddressbookData personData = null;
		personData=new AddressbookData(1, bookDTO);
		return personData;
	}
	
	@Override
	public void deleteAddressbookData(int id) {
		
	}
	
}
