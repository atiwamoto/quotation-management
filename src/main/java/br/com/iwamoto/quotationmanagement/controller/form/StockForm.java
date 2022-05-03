package br.com.iwamoto.quotationmanagement.controller.form;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockForm {

	private String id;
	private String stockId;
	
	@JsonProperty("quotes")
	private Map<String,String> quotes = new HashMap<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public Map<String, String> getQuotes() {
		return quotes;
	}
	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}

}
