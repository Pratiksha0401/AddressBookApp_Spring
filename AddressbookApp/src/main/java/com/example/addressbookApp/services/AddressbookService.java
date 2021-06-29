package com.example.addressbookApp.services;

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
	
	
	@Override
	public List<AddressbookData> getAddressbookData() {
		return addressbookrepo.findAll();
	}

	@Override
	public AddressbookData getAddressbookDataById(int id) {
		return addressbookrepo
				.findById(id)
				.orElseThrow(() -> new AddressBookException("Person Not Id: "+id+
						                                     "doesn't exist."));}

	@Override
	public AddressbookData createAddressbookData(AddressbookDTO bookDTO) {
		AddressbookData bookData = null;
		bookData=new AddressbookData(bookDTO);
		log.debug("Person Data: "+bookData.toString());
		return addressbookrepo.save(bookData);
	}
	
	@Override
	public AddressbookData updateAddressbookData(int id,AddressbookDTO bookDTO) {
		AddressbookData bookData = this.getAddressbookDataById(id);
		bookData.updateAddressbookData(bookDTO);
		return addressbookrepo.save(bookData);
	}
	
	@Override
	public void deleteAddressbookData(int id) {
		AddressbookData bookData = this.getAddressbookDataById(id);
		addressbookrepo.delete(bookData);
	}

	@Override
	public long getCountById() {
		return addressbookrepo.count();
	}

	@Override
	public long getCountByState(String state) {
		return addressbookrepo.countByState(state);
	}

	@Override
	public long getCountByCity(String city) {
		return addressbookrepo.countByCity(city);
	}

	@Override
	public List<AddressbookData> getAddressbookDataByState(String state) {
		return addressbookrepo.getAddressbookdataByState(state);
	}

	@Override
	public List<AddressbookData> getAddressbookDataByCity(String city) {
		return addressbookrepo.getAddressbookdataByCity(city);
	}

	@Override
	public List<AddressbookData> getAddressbookDataByNameKeyword(String keyword) {
		return addressbookrepo.getAddressbookdataByNameKeyword(keyword);
	}
	
}
