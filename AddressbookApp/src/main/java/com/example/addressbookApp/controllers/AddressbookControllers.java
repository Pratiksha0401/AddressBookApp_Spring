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
	
	@GetMapping(value={" ", "/","/get"})
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
	
	@GetMapping("/countbyId")
	public ResponseEntity<ResponseDTO> getCountById() {
		long countById = 0;
		countById = addressbookservice.getCountById();
		ResponseDTO respDTO = new ResponseDTO("Get Call for count by Id", countById);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/countbyState/{State}")
	public ResponseEntity<ResponseDTO> getCountByState(@PathVariable("State") String state) {
		long countByState = 0;
		countByState = addressbookservice.getCountByState(state);
		ResponseDTO respDTO = new ResponseDTO("Get Call for count by State", countByState);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/countbyCity/{City}")
	public ResponseEntity<ResponseDTO> getCountByCity(@PathVariable("City") String city) {
		long countByCity = 0;
		countByCity = addressbookservice.getCountByCity(city);
		ResponseDTO respDTO = new ResponseDTO("Get Call for count by City", countByCity);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getByState/{State}")
	public ResponseEntity<ResponseDTO> getAddressbookDataByState(@PathVariable("State") String state){
		List<AddressbookData> bookDataList = null;
		bookDataList = addressbookservice.getAddressbookDataByState(state);
		ResponseDTO respDTO = new ResponseDTO("Get Call for get data by state", bookDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getByCity/{City}")
	public ResponseEntity<ResponseDTO> getAddressbookDataByCity(@PathVariable("City") String city){
		List<AddressbookData> bookDataList = null;
		bookDataList = addressbookservice.getAddressbookDataByCity(city);
		ResponseDTO respDTO = new ResponseDTO("Get Call for get data by city", bookDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getByNameKeyword/{namekeyword}")
	public ResponseEntity<ResponseDTO> getAddressbookDataByNameKeyword(@PathVariable("namekeyword") String namekeyword){
		List<AddressbookData> bookDataList = null;
		bookDataList = addressbookservice.getAddressbookDataByNameKeyword(namekeyword);
		ResponseDTO respDTO = new ResponseDTO("Get Call for get data by keyword", bookDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
		
}
