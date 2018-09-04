package com.testtask.entity;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Article")
public class Article {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column (name="name")
	private String name;

	@Column (name="date")
	@DateTimeFormat(pattern="YYYY-MM-dd HH:mm:ss")
	private Timestamp date;
	
	@Column (name="text")
	private String text;
	
	
	@Column (name="category")
	private String category;
	
	
	public Article() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(String date) {
		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);


		try {
             java.util.Date dat=(format.parse(date));
			this.date= new Timestamp(dat.getTime()) ;
		} catch (ParseException e) {e.printStackTrace();}
		

		
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
