package com.example.BrownCoffee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BrownCoffee.entities.Product;
import com.example.BrownCoffee.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	    private ProductRepository productRepository;
	 	
	 	public ProductService(ProductRepository productRepository) {
			this.productRepository = productRepository;
		}
	 	
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
	    

	    public Product getProductById(Long id) {
	    	Optional <Product> existProduct = productRepository.findById(id);
	        return existProduct.orElse(null);
	    }

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Product updateProduct(Long id, Product updateProduct) {
	    	Optional <Product> existProduct = productRepository.findById(id);
			if (existProduct.isPresent()) {
				updateProduct.setId(id);
				return productRepository.save(updateProduct);
			}
			return null;
	    }

	    public boolean deleteProduct(Long id) {
	    	Optional <Product> existProduct = productRepository.findById(id);
			if (existProduct.isPresent()) {
				productRepository.deleteById(id);
				return true;
			}
			return false;
	    }
}
