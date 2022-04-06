package br.com.iwamoto.quotationmanagement.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quote {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Stock stock;
	
	private LocalDate date;
	
	private double value;

	public Quote() {
		super();
	}
	
	public Quote(LocalDate date, double value, Stock stock) {
		super();
		this.date = date;
		this.value = value;
		this.stock = stock;
	}

	public Stock getStock() {
		return stock;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}
