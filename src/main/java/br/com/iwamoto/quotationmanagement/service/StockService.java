package br.com.iwamoto.quotationmanagement.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.iwamoto.quotationmanagement.service.form.StockServiceForm;

@Service
public class StockService {
	
	public List<StockServiceForm> listStocks(){
		String uri = "http://localhost:8080/stock";
		RestTemplate r = new RestTemplate();
		ResponseEntity<StockServiceForm[]> responseEntity = r.getForEntity(uri, StockServiceForm[].class);
		StockServiceForm[] objects = responseEntity.getBody();
		return Arrays.stream(objects).collect(Collectors.toList());
	}
	
	public static void registerAtStockManager() {

	    Map<String, Object> map = new HashMap<>();
	    map.put("host", "localhost");
	    map.put("port", 8081);

	    RestTemplate restTemplate = new RestTemplate();   

	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	    String response = restTemplate.postForObject("http://localhost:8080/notification", map, String.class);
	    System.out.println("response: " + response);

	}
	

}
