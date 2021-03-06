package br.com.iwamoto.quotationmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import br.com.iwamoto.quotationmanagement.service.StockService;

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport
public class QuotationManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(QuotationManagementApplication.class, args);
		StockService.registerAtStockManager();		
	}

}
