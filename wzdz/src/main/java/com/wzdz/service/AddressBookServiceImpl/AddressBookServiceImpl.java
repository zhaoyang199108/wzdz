package com.wzdz.service.AddressBookServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.AddressBookDao;
import com.wzdz.entity.AddressBook;
import com.wzdz.service.AddressBookService;

@Service
public class AddressBookServiceImpl implements AddressBookService{

	@Autowired
	private  AddressBookDao addressBookDao;
	
	public List<AddressBook> findAll() {
		return addressBookDao.findAll();
	}
	

}
