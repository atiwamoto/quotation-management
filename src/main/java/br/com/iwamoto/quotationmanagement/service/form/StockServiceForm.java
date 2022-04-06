package br.com.iwamoto.quotationmanagement.service.form;

public class StockServiceForm {

	private String id;
	private String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "StockForm [id=" + id + ", description=" + description + "]";
	}	
	
}
