package br.com.iwamoto.quotationmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.iwamoto.quotationmanagement.model.Quote;

@DataJpaTest
public class QuoteRepositoryTest {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Test
	public void shouldNotLoadQuotesFromInvalidStockId() {
		List<Quote> findByStockId = quoteRepository.findByStockId("petr4");
		assertTrue(findByStockId.isEmpty());			
	}

	
}
