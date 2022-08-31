package com.ttj.usermgmt.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ttj.usermgmt.domain.Product;
import com.ttj.usermgmt.domain.ProductDTO;
import com.ttj.usermgmt.repo.ProductDao;
import com.ttj.usermgmt.service.JwtProductService;

@RestController
public class ProductController {
	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductDao productDao;

	@Autowired
	private JwtProductService jwtProductService;

	@RequestMapping(value = "/createproduct", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> product(@RequestBody ProductDTO productDTO) {
		logger.info("Create Product");
		jwtProductService.save(productDTO);
		return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getProduct() {
		logger.info("Get Product");
		jwtProductService.getProduct();
		return new ResponseEntity<>(jwtProductService, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Integer id) {
		logger.info("Delete Product");
		jwtProductService.delete(id);
		return new ResponseEntity<>("Delete Product", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getProductById(@PathVariable(value = "id") Integer id) {
		logger.info("Get Product By Id");
		return new ResponseEntity<>(jwtProductService.getProductById(id), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
		logger.info("Update Product");
		jwtProductService.update(productDTO);
		return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
	}
	

}
