package com.testtask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testtask.dao.CategDAO;
import com.testtask.entity.Category;


@Service
@Transactional
public class ServiceCatImp implements CatService{

	@Autowired
	public CategDAO category;

	@Override
	public void addAndUpdate(Category categor) {
		category.addAndUpdate(categor);
		
	}

	@Override
	public List<Category> getCategories() {
		return category.getCategories();
	}

	@Override
	public void delete(int id) {
		category.delete(id);
		
	}

	@Override
	public Category getCategory(int id) {
		return category.getCategory(id);
	}



}
