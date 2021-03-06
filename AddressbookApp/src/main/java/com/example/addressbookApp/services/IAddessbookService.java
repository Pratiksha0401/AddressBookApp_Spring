package com.example.addressbookApp.services;

import java.util.List;

import com.example.addressbookApp.dto.AddressbookDTO;
import com.example.addressbookApp.model.AddressbookData;

public interface IAddessbookService {
	List<AddressbookData> getAddressbookData();
	AddressbookData getAddressbookDataById(int id);
	AddressbookData createAddressbookData(AddressbookDTO bookDTO);
	AddressbookData updateAddressbookData(int id,AddressbookDTO bookDTO);
	void deleteAddressbookData(int id);
	long getCountById();
	long getCountByState(String state);
	long getCountByCity(String city);
	List<AddressbookData> getAddressbookDataByState(String state);
	List<AddressbookData> getAddressbookDataByCity(String city);
	List<AddressbookData> getAddressbookDataByNameKeyword(String keyword);
	
}
