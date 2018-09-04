package com.testtask.service;

import java.util.List;


import com.testtask.entity.Category;

public interface CatService {

	
void addAndUpdate(Category category);
	
	List<Category> getCategories();
	
	void delete(int id);
	
	Category getCategory(int id);
	

}
