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

@RestController
@RequestMapping("/addressbook")
public class AddressbookControllers {
	
	//curl "localhost:8080/addressbook/get" -w "\n"
	@RequestMapping(value={" ", "/","/get"})
	public ResponseEntity<String> getAddressbookData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
		
	//curl "localhost:8080/addressbook/get/1" -w "\n"
	@GetMapping("/get/{Id}")
	public ResponseEntity<String> getAddressbookData(@PathVariable("Id") int Id){
		return new ResponseEntity<String>("Get Call Success for id: "+ Id, HttpStatus.OK);
	}
		
	/*  curl -X POST -H "Content-Type:application/json" -d '{"firstName":"Pratiksha","lastName":"Nagoshe","address":"Bhandara"}'
	 *  "http://localhost:8080/addressbook/create" -w "\n" */
	@PostMapping("/create")
	public ResponseEntity<String> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
		return new ResponseEntity<String>("Created Address Book Data for: "+ addressbookDTO, HttpStatus.OK);
	}
	
	/*curl -X PUT -H "Content-Type:application/json" -d '{"firstName":"Pratiksha","lastName":"Nagoshe","address":"Bhandara,MH"}'
	 *  "http://localhost:8080/addressbook/update" -w "\n"
	 */
	@PutMapping("/update")
	public ResponseEntity<String> updateAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
		return new ResponseEntity<String>("Updated address Book Data for: "+addressbookDTO, HttpStatus.OK);
	}
	
	/* curl -X DELETE -H "Content-Type:application/json" -d '{"firstName":"Pratiksha","lastName":"Nagoshe","address":"Bhandara,MH"}' 
	 * "http://localhost:8080/addressbook/delete/1" -w "\n"
	 */
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> deleteAddressbookData(@PathVariable("Id") int Id) {
		return new ResponseEntity<String>("Delete Call Success for id: "+Id, HttpStatus.OK);
	}
	

}
