package com.example.addressbookApp.controllers;

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

@RestController
@RequestMapping("/addressbook")
public class AddressbookControllers {
	
	//curl "localhost:8080/addressbook/get" -w "\n"
	@RequestMapping(value={" ", "/","/get"})
	public ResponseEntity<ResponseDTO> getAddressbookData() {
		AddressbookData bookData = new AddressbookData(1,new AddressbookDTO("Pratiksha","Nagoshe","Bhandara"));
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
		
	//curl "localhost:8080/addressbook/get/1" -w "\n"
	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable("Id") int Id){
		AddressbookData bookData = new AddressbookData(1,new AddressbookDTO("Pratiksha","Nagoshe","Bhandara"));
		ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successful", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
		
	/*  curl -X POST -H "Content-Type:application/json" -d '{"firstName":"Pratiksha","lastName":"Nagoshe","address":"Bhandara"}'
	 *  "http://localhost:8080/addressbook/create" -w "\n" */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
		AddressbookData bookData = new AddressbookData(1,addressbookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Addressbook Data Successfully", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/*curl -X PUT -H "Content-Type:application/json" -d '{"firstName":"Pratiksha","lastName":"Nagoshe","address":"Bhandara,MH"}'
	 *  "http://localhost:8080/addressbook/update" -w "\n"
	 */
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
		AddressbookData bookData = new AddressbookData(1,addressbookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Addressbook Data Successfully", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/* curl -X DELETE -H "Content-Type:application/json" -d '{"firstName":"Pratiksha","lastName":"Nagoshe","address":"Bhandara,MH"}' 
	 * "http://localhost:8080/addressbook/delete/1" -w "\n"
	 */
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("Id") int Id) {
		ResponseDTO respDTO = new ResponseDTO("Created Addressbook Data Successfully", "Deleted Id : "+ Id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
}
