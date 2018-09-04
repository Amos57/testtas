package com.testtask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testtask.dao.ArticleDAO;
import com.testtask.entity.Article;


@Service
@Transactional
public class ServiceImp implements Servicem {

@Autowired
	public ArticleDAO articleDao;



	
	
	@Override
	public void addAndUpdate(Article article) {
	articleDao.addAndUpdate(article);
		
	}

	@Override
	public List<Article> getArticles() {

		return articleDao.getArticles();
	}

	@Override
	public void delete(int id) {
	articleDao.delete(id);
	}

	@Override
	public Article getArticle(int id) {

		return articleDao.getArticle(id);
	}

	@Override
	public List<Article> get(String category)  {
		return articleDao.get(category);
	}




}
