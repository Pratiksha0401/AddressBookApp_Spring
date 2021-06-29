package com.example.addressbookApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.addressbookApp.model.AddressbookData;

public interface AddressBookRepository extends JpaRepository<AddressbookData, Integer>{
	
	@Query(value="select count(State) from addressbook_data where State=?1", nativeQuery=true)
	long countByState(String state);
	
	@Query(value="select count(City) from addressbook_data where City=?1", nativeQuery=true)
	long countByCity(String city);
	
	@Query(value="select * from addressbook_data where State=?1", nativeQuery=true)
	List<AddressbookData> getAddressbookdataByState(String state);
	
	@Query(value="select * from addressbook_data where City=?1", nativeQuery=true)
	List<AddressbookData> getAddressbookdataByCity(String city);
	
	@Query(value="select * from addressbook_data where name like ?1% ", nativeQuery=true)
	List<AddressbookData> getAddressbookdataByNameKeyword(String keyword);

}
