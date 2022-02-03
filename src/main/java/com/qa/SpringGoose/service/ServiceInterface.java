package com.qa.SpringGoose.service;

import java.util.List;

public interface ServiceInterface<T> {
	

	
	//Create a create method 
	
	T create(T t);
	
	// READ All
	List<T> readAll();

	//Read By Id 
	T readById(Long id);
	
	//Update // We take the id to identify where it is, we take in an object to then replace its contents.
	T update(Long id, T t);
	
	//Delete
	boolean delete(Long id);

}
