package com.example.addressbookApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbookApp.dto.AddressbookDTO;
import com.example.addressbookApp.exceptions.AddressBookException;
import com.example.addressbookApp.model.AddressbookData;
import com.example.addressbookApp.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressbookService implements IAddessbookService{
	
	@Autowired
	private AddressBookRepository addressbookrepo;
	
	private List<AddressbookData> addressbookDataList = new ArrayList<>();
	
	@Override
	public List<AddressbookData> getAddressbookData() {
		return addressbookDataList;
	}

	@Override
	public AddressbookData getAddressbookDataById(int id) {
		return addressbookDataList.stream()
								.filter(bookData -> bookData.getId()==id)
								.findFirst()
								.orElseThrow(() -> new AddressBookException("Person Not Found"));
	}

	@Override
	public AddressbookData createAddressbookData(AddressbookDTO bookDTO) {
		AddressbookData bookData = null;
		bookData=new AddressbookData(addressbookDataList.size()+1, bookDTO);
		log.debug("Person Data: "+bookData.toString());
		addressbookDataList.add(bookData);
		return addressbookrepo.save(bookData);
	}
	
	@Override
	public AddressbookData updateAddressbookData(int id,AddressbookDTO bookDTO) {
		AddressbookData bookData = this.getAddressbookDataById(id);
		bookData.setName(bookDTO.name);
		bookData.setAddress(bookDTO.address);
		bookData.setCity(bookDTO.city);
		bookData.setState(bookDTO.state);
		bookData.setZipcode(bookDTO.zipcode);
		bookData.setPhonenumber(bookDTO.phonenumber);
		return addressbookDataList.set(id-1,bookData);
	}
	
	@Override
	public void deleteAddressbookData(int id) {
		AddressbookData bookData = this.getAddressbookDataById(id);
		addressbookDataList.remove(bookData);
	}
	
}
