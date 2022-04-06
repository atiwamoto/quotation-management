package br.com.iwamoto.quotationmanagement.controller.form;

import java.time.LocalDateTime;

public class QuoteForm {

	private LocalDateTime date;	
	private double value;
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}	
}
