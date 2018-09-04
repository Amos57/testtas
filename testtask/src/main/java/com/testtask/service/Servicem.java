package com.testtask.service;

import java.util.List;

import com.testtask.entity.Article;

public interface Servicem {

	
	void addAndUpdate(Article article);
	
	List<Article> getArticles();
	
	void delete(int id);
	
	Article getArticle(int id);
	

    List<Article> get(String category);

	
}
