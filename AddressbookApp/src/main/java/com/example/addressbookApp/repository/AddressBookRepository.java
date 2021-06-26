package com.example.addressbookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressbookApp.model.AddressbookData;

public interface AddressBookRepository extends JpaRepository<AddressbookData, Integer>{

}
