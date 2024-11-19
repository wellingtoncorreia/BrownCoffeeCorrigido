package com.example.BrownCoffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BrownCoffee.entities.Product;
import com.example.BrownCoffee.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {
	@Autowired
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductControlId(@PathVariable Long id){
		Product  product = productService.getProductById(id);
		if(product != null) {
			return ResponseEntity.ok(product);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Product>> getAllProductControl(){
		List<Product> product = productService.getAllProducts();
		return ResponseEntity.ok(product);
	}

	@PostMapping
	public ResponseEntity<Product> saveProductControl(@RequestBody @Valid Product product){
		Product saveProduct = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductControl(@PathVariable Long id, @RequestBody @Valid Product product){
		Product updateProduct = productService.updateProduct(id, product);
		if(updateProduct != null) {
			return ResponseEntity.ok(product);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProductControl(@PathVariable Long id){
		boolean apagar = productService.deleteProduct(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
