package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testApi() throws Exception {
		mvc.perform(get("/api"))
			.andExpect(status().isOk())
			.andExpect(content().json("{'mensaje': 'Hola mundo'}"))
		;
	}

	@Test
	public void testApiParam() throws Exception {
		mvc.perform(get("/api/{nombre}", "Nombre de prueba"))
			.andExpect(status().isOk())
			.andExpect(content().json("{'mensaje': 'Hola Nombre de prueba'}"))
		;
	}

}
