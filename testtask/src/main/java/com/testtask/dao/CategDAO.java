package com.testtask.dao;

import java.util.List;

import com.testtask.entity.Category;

public interface CategDAO {

	
	void addAndUpdate(Category category);
	
	List<Category> getCategories();
	
	void delete(int id);
	
	Category getCategory(int id);
	
}
