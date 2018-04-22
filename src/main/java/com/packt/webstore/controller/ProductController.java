package com.packt.webstore.controller;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.validator.ProductValidator;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductValidator productValidator;
	
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitInOrder", "discontinued");
		binder.setValidator(productValidator);
	}
	
	
	@RequestMapping
	public String list(Model model) {
//		Product iphone5 = new Product("P12345", "iphone 5s", new BigDecimal(500));
//		iphone5.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
//		iphone5.setCategory("Smart Phone");
//		iphone5.setManufacturer("Apple");
//		iphone5.setUnitsInStock(1000);
//		model.addAttribute("product", iphone5);
		model.addAttribute("products", productService.getAllProducts());
		return "products";
		
	}
	
	
	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	
	@RequestMapping("/{category}")
	public String getProductByCategory(Model model, @PathVariable String category) {
		
		List<Product> productList = productService.getProductByCategory(category);
		if (productList == null || productList.isEmpty()) {
			throw new NoProductFoundUnderCategoryException();
		}
		
		model.addAttribute("products", productList);
		return "products";
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductByFilter(Model model, @MatrixVariable(pathVar="ByCriteria")
	Map<String, List<String>> filterParams) {
		model.addAttribute("products", productService.getProductByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProduct(Model model, @RequestParam("id") String productId) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping("/{category}/{price}")
	public String filterProducts(@PathVariable String category, @MatrixVariable(pathVar="price")
	Map<String, List<String>> filterParams, @RequestParam String manufacturer, Model model) {
		Set<Product> productByCategory = null;
		Set<Product> productByPrice = new HashSet<Product>();
		Set<Product> productByManufacturer = null;

		productByCategory = new HashSet<Product>(productService.getProductByCategory(category));
		productByPrice = productService.getProductByPriceFilter(filterParams);
		productByManufacturer = new HashSet<Product>(productService.getProductByManufacturer(manufacturer));
		
		productByCategory.addAll(productByPrice);
		productByCategory.addAll(productByManufacturer);
		model.addAttribute("products", productByCategory);
		
		return "products";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product product) {
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product product, BindingResult result, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			return "addProduct";
		}
		
		if (result.getSuppressedFields().length > 0) {
			throw new RuntimeException("Attempt to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(result.getSuppressedFields()));
		}
		Product productToBeAdded = product;
		MultipartFile productImage = productToBeAdded.getProductImage();
		MultipartFile userManual = productToBeAdded.getUserManual();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo( new File(rootDirectory + "resources\\images\\"+productToBeAdded.getProductId() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed",e);
			}
		}
		
		if (userManual != null && !userManual.isEmpty()) {
			try {
				userManual.transferTo( new File(rootDirectory + "resources\\pdf\\"+productToBeAdded.getProductId() + ".pdf"));
			} catch (Exception e) {
				throw new RuntimeException("Product user manual saving failed",e);
			}
		}
		
		productService.addProduct(product);
		return "redirect:/products";
	}
	
	@ExceptionHandler
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("invalidProductId", e.getProductId());
		mv.addObject("exception", e);
		mv.addObject("url: ", req.getRequestURL() + "?" + req.getQueryString());
		mv.setViewName("productNotFound");
		return mv;
	}
	
	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}
	
}
