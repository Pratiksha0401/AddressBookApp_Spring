package com.example.addressbookApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbookApp.dto.AddressbookDTO;
import com.example.addressbookApp.dto.ResponseDTO;
import com.example.addressbookApp.model.AddressbookData;
import com.example.addressbookApp.services.IAddessbookService;

@RestController
@RequestMapping("/addressbook")
public class AddressbookControllers {
	
	@Autowired
	private IAddessbookService addressbookservice;
	
	@RequestMapping(value={" ", "/","/get"})
	public ResponseEntity<ResponseDTO> getAddressbookData() {
		List<AddressbookData> bookDataList = null;
		bookDataList = addressbookservice.getAddressbookData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", bookDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
		

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getAddressbookDataById(@PathVariable("Id") int id){
		AddressbookData bookData = null;
		bookData = addressbookservice.getAddressbookDataById(id);
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
		

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO) {
		AddressbookData bookData = null;
		bookData = addressbookservice.createAddressbookData(addressbookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Addressbook Data Successfully", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	

	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable("Id") int id,
															 @Valid @RequestBody AddressbookDTO addressbookDTO) {
		AddressbookData bookData = null;
		bookData = addressbookservice.updateAddressbookData(id,addressbookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Addressbook Data Successfully", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("Id") int id) {
		addressbookservice.deleteAddressbookData(id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Addressbook Data Successfully", "Deleted Id : "+ id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
}
