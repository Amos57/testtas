package com.testtask.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;



import com.testtask.entity.Article;
import com.testtask.entity.Category;

public class CategDAOImp implements CategDAO{

	
	
	 @Autowired
	 private SessionFactory sessionFactory;

	 protected Session getSession(){
	  return sessionFactory.getCurrentSession();
	 }
	
	@Override
	public void addAndUpdate(Category category) {
		getSession().saveOrUpdate(category);
		
	}

	@Override
	public List<Category> getCategories() {
		 Criteria criteria = getSession().createCriteria(Category.class);
		  return (List<Category>) criteria.list();
	}

	@Override
	public void delete(int id) {
		  Category category = (Category) getSession().get(Article.class, id);
		  getSession().delete(category);
		
	}

	@Override
	public Category getCategory(int id) {
		Category category = (Category) getSession().get(Article.class, id);
		return category;
	}

}
