package br.com.iwamoto.quotationmanagement.controller.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.iwamoto.quotationmanagement.model.Stock;
import br.com.iwamoto.quotationmanagement.service.form.StockServiceForm;

public class StockDto {
	
	private UUID id;	
	private String stockId;
	
	@JsonProperty("quotes")
	private Map<String,String> quotes = new HashMap<>();

	public StockDto(Stock stock, List<StockServiceForm> listStocks) {
		this.id = stock.getId();
		this.stockId = stock.getStockId();
/*		this.description = listStocks.stream()
									.filter(s -> s.getId().equals(this.stockId) )
									.findAny().get().getDescription(); */
	}

	public StockDto() {
		super();
	}
	
	public StockDto(UUID id, String stockId) {
		super();
		this.id = id;
		this.stockId = stockId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public static StockDto convert(Stock stock) {
		StockDto dto = new StockDto(stock.getId(), stock.getStockId());
		stock.getQuotes().forEach(q -> dto.getQuotes().put( q.getDate().toString(), String.valueOf(q.getValue()) ));
		return dto;		
	}

}
