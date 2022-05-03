package br.com.iwamoto.quotationmanagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.iwamoto.quotationmanagement.model.Quote;

public interface QuoteRepository extends CrudRepository<Quote, UUID> {
	
	@Query(value = "SELECT * FROM quote q WHERE q.stock_id = :id", nativeQuery = true)
	List<Quote> findByStockId(String id);
	
	@Query(value = "SELECT * FROM quote q WHERE q.date = :date and q.value = :value and q.stock_id = :id", nativeQuery = true)
	Optional<Quote> findByDataValorStockId(LocalDate date, double value, String id);
	
}

