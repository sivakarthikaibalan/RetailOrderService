package com.epam.retail;

import com.epam.retail.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
class OrderServiceApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void noDiscounts() throws Exception {
		String uri = "/newOrder?apple=1&orange=2";
		mockMvc.perform(post(uri))
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"grandTotal\":1.1")));

	}
	@Test
	void appleDiscounts() throws Exception {
		String uri = "/newOrder?apple=2&orange=2";
		mockMvc.perform(post(uri))
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"grandTotal\":1.1")));

	}
	@Test
	void orangeDiscounts() throws Exception {
		String uri = "/newOrder?apple=2&orange=3";
		mockMvc.perform(post(uri))
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"grandTotal\":1.1")));

	}
	@Test
	void noOrange() throws Exception {
		String uri = "/newOrder?apple=2";
		mockMvc.perform(post(uri))
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"grandTotal\":0.6")));

	}
	@Test
	void noApple() throws Exception {
		String uri = "/newOrder?orange=2";
		mockMvc.perform(post(uri))
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"grandTotal\":0.5")));

	}
	@Test
	void noAppleOrange() throws Exception {
		String uri = "/newOrder?";
		mockMvc.perform(post(uri))
				.andExpect(status().isOk()).andExpect(content().string(containsString("\"grandTotal\":0.0")));

	}

}
