package br.com.iwamoto.quotationmanagement.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.iwamoto.quotationmanagement.controller.dto.QuoteDto;
import br.com.iwamoto.quotationmanagement.controller.dto.StockDto;
import br.com.iwamoto.quotationmanagement.controller.form.StockForm;
import br.com.iwamoto.quotationmanagement.model.Quote;
import br.com.iwamoto.quotationmanagement.model.Stock;
import br.com.iwamoto.quotationmanagement.repository.QuoteRepository;
import br.com.iwamoto.quotationmanagement.repository.StockRepository;
import br.com.iwamoto.quotationmanagement.service.StockService;
import br.com.iwamoto.quotationmanagement.service.form.StockServiceForm;


@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<StockDto> cadastrar(@RequestBody @Valid StockForm form, UriComponentsBuilder uriBuilder) {
		Optional<Stock> optStock = stockRepository.findByStockId(form.getStockId());
		
		Stock stock;
		
		if(getListFromStockManager().stream().filter(s -> s.getId().equals(form.getStockId()) ).count() <= 0)
			return ResponseEntity.status(400).build();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		if(!optStock.isPresent()) {
			stock = new Stock(form.getStockId());
			stockRepository.save(stock);
		}else
			stock = optStock.get();
		
		for (Map.Entry<String,String> pair : form.getQuotes().entrySet()) {
			
			double valor = Double.parseDouble(pair.getValue());
			LocalDate data = LocalDate.parse(pair.getKey(), formatter);
			
			if(!quoteRepository.findByDataValorStockId(data, valor, stock.getId().toString()).isPresent()) {
			    Quote quote = new Quote(data ,valor , stock);
				quoteRepository.save(quote);
			}
		}
		stock.setQuotes(quoteRepository.findByStockId(stock.getId().toString()));
		return ResponseEntity.ok(StockDto.convert(stock));

	}
	
	@GetMapping("/{idStock}")
	@Transactional
	public ResponseEntity<StockDto> listaById(@PathVariable String idStock) {
		Optional<Stock> stock = stockRepository.findById(idStock);	
		if(stock.isPresent()) {
			List<Quote> quotes = quoteRepository.findByStockId(stock.get().getId().toString());
			List<QuoteDto> qdto = new ArrayList<QuoteDto>();
			quotes.forEach(q -> qdto.add(new QuoteDto(q.getDate(), q.getValue())));
			return ResponseEntity.ok(StockDto.convert(stock.get()));
		}
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<StockDto>> listAll() {
		List<Stock> stock = (List<Stock>) stockRepository.findAll();
		List<StockDto> list = new ArrayList<StockDto>();
		
		stock.forEach(s -> list.add(loadDto(s)));		
		
		if(list.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(list);
		
	}
	
	private StockDto loadDto(Stock s) {
		List<Quote> quotes = quoteRepository.findByStockId(s.getId().toString());
		s.setQuotes(quotes);		
		return StockDto.convert(s);
	}

	@Cacheable(value = "listFromStockManager")
	private List<StockServiceForm> getListFromStockManager(){
		return stockService.listStocks();
	}
	
}
