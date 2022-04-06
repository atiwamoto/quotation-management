package br.com.iwamoto.quotationmanagement.controller.dto;

import java.time.LocalDate;

public class QuoteDto {

	private LocalDate date;	
	private double value;
		
	public QuoteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuoteDto(LocalDate date, double value) {
		super();
		this.date = date;
		this.value = value;
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
