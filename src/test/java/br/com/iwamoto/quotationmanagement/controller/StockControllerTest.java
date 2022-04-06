package br.com.iwamoto.quotationmanagement.controller;

import static org.assertj.core.api.Assertions.fail;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void shouldReturn404CaseInvalidStockWasInformed() throws Exception {
		URI uri = new URI("/stock/INVALID");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}
	
}
