package br.com.iwamoto.quotationmanagement.controller;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stockcache")
public class StockCacheController {
	
	@DeleteMapping
	@Transactional
	@CacheEvict(value = "listFromStockManager", allEntries = true)
	public ResponseEntity<?> remover() {
		return ResponseEntity.ok().build();
	}

}
