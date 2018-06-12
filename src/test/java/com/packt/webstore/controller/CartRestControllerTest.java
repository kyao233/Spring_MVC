package com.packt.webstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class CartRestControllerTest {

	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	MockHttpSession session;
	
	private MockMvc mockMvc;
	
	private ObjectMapper mapper;
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		this.mapper = new ObjectMapper();
	}
	
	
	
	@Test
	public void read_method_should_return_correct_cart_Json_object() throws Exception {
		//Arrange
		this.mockMvc.perform(put("/rest/cart/add/P1234").session(session))
		.andExpect(status().is(204));
		
		
		//Act
		this.mockMvc.perform(get("/rest/cart/" +
		session.getId()).session(session))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.cartItems.P1234.product.productId").value("P1234"));
		
		
	}
	
	
	@Test
	public void create_method_should_return_same_cart() throws Exception {
		//Arrange 
		Cart cart = new Cart("C12345");
		String cartStr = this.mapper.writeValueAsString(cart);
		
		//Act
		this.mockMvc.perform(post("/rest/cart").content(cartStr).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.cartId").value("C12345"));
		
	}
	
	@Test
	public void update_method_should_return_updated_cart() throws Exception {
		//Arrange 
		Cart cart = new Cart("C123456");
		String cartStr = this.mapper.writeValueAsString(cart);
		Cart updatedCart = new Cart("C123456");
		Product product = new Product("P1234", "iphone 5s", new BigDecimal(500));
		CartItem cartItem = new CartItem(product);
		Map<String, CartItem> cartItems = new HashMap<String, CartItem>();
		cartItems.put("P1234", cartItem);
		updatedCart.setCartItems(cartItems);
		String updatedCartStr = this.mapper.writeValueAsString(updatedCart);
		
		
		this.mockMvc.perform(post("/rest/cart").content(cartStr).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		//act
		this.mockMvc.perform(put("/rest/cart/C123456").content(updatedCartStr).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
		
		//Assert
		this.mockMvc.perform(get("/rest/cart/C123456"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.cartItems.P1234.product.productId").value("P1234"));
	}
	
	@Test
	public void delete_method_should_delete_cart() throws Exception {
		//Arrange
		this.mockMvc.perform(put("/rest/cart/add/P1234").session(session))
		.andExpect(status().is(204));
		
		//Act
		this.mockMvc.perform(delete("/rest/cart/" + session.getId()))
		.andExpect(status().is(204));
		
		//Assert
		this.mockMvc.perform(get("/rest/cart/" + session.getId()))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}
	
}
