package com.testtask.dao;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.testtask.entity.Article;

@Repository
public class ArticleDAOImp implements ArticleDAO{

	 @Autowired
	 private SessionFactory sessionFactory;

	 protected Session getSession(){
	  return sessionFactory.getCurrentSession();
	 }
	
	
	@Override
	public void addAndUpdate(Article article) {
		getSession().saveOrUpdate(article);
		
	}

	@Override
	public List<Article> getArticles() {
		 Criteria criteria = getSession().createCriteria(Article.class);
		  return (List<Article>) criteria.list();
		
	}

	@Override
	public void delete(int id) {
		  Article customer = (Article) getSession().get(Article.class, id);
		  getSession().delete(customer);
		
	}

	@Override
	@Transactional
	public Article getArticle(int id) {
		Article article=(Article) getSession().get(Article.class, id);
		return article;
	}


	@Override
	public List<Article> get(String text) {


			Criteria	results = getSession().createCriteria(Article.class)
					.add(Restrictions.or(
							Restrictions.eq("category", text),
							Restrictions.eq("name", text),
							Restrictions.like("text", "%" + text + "%")));
			List<Article> result=(List)results.list();
  
		return result;
	}



	

}
