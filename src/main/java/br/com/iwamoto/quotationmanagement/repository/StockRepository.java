package br.com.iwamoto.quotationmanagement.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.iwamoto.quotationmanagement.model.Stock;

public interface StockRepository extends CrudRepository<Stock, UUID> {
	
	Optional<Stock> findByStockId(String stockId);

	@Query(value = "SELECT * FROM stock s WHERE s.stock_id = :id1", nativeQuery = true)
	Optional<Stock> findById(String id1);
	
}