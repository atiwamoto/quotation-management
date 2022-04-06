package br.com.iwamoto.quotationmanagement.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.iwamoto.quotationmanagement.model.Quote;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class QuoteRepositoryTest {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Test
	public void test() {		
		List<Quote> findByStockId = quoteRepository.findByStockId("petr4");
		assertTrue(findByStockId.isEmpty());			
	}

}
