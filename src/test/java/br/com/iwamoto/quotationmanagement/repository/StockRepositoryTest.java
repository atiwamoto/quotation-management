package br.com.iwamoto.quotationmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.iwamoto.quotationmanagement.model.Stock;


@SpringBootTest
class StockRepositoryTest {

	@Autowired
	private StockRepository stockRepository;
	
	@Test
	public void shouldNotLoadInvalidStockId() {
		Optional<Stock> findByStockId = stockRepository.findByStockId("invalid");
		assertTrue(!findByStockId.isPresent());			
	}
}
