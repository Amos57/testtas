package com.testtask.dao;

import java.util.List;

import com.testtask.entity.Article;

public interface ArticleDAO {

	
	void addAndUpdate(Article article);
	
	List<Article> getArticles();
	
	void delete(int id);
	
	Article getArticle(int id);
	
    List<Article> get(String category) ;
    

	
}
