package com.testtask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testtask.entity.Article;
import com.testtask.service.CatService;
import com.testtask.service.Servicem;


@Controller
@RequestMapping("/")
public class ArticleController {

	@Autowired
	public Servicem service;

	@Autowired
	public CatService catService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@GetMapping("/articles")
	public String getAllArticles(Model model){
		model.addAttribute("articles",service.getArticles());
		return "articleslist";
	}
	
	@GetMapping("/article/{id}")
	public String getArticle(@PathVariable("id") int id,Model model){
		model.addAttribute("article",service.getArticle(id));
		return "showArticle";
	}

	@GetMapping("/addArticle")
	public String getArticlePage(Model model){
	model.addAttribute("categories", catService.getCategories());
		return "createArticlePage";
	}

	@PostMapping("/addArticle")
	public String addArticle(@ModelAttribute("article") Article article){
		service.addAndUpdate(article);

		return "redirect:/articles";
	}

	@GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id){
	    service.delete(id);
	    return "redirect:/articles";

    }
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		Article article =service.getArticle(id);
		model.addAttribute("article", article);
		model.addAttribute("categories", catService.getCategories());
		return "editArticle";
	}
	@PostMapping("/updateArticle")
	public String updateArticle(@ModelAttribute("article")Article article) {

		service.addAndUpdate(article);
		return "redirect:/article/" + article.getId();
	}
	@PostMapping("/search")
	public String search(@ModelAttribute("info") String info, Model model){
        List<Article> a=service.get(info);
			model.addAttribute("articles", a);
		if(a.isEmpty() || info.isEmpty()){
			/**
			 * 
			 */
			return "error";
		}
		return "resultlist";
	}
}
