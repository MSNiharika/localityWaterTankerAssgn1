package com.niharika.tutorials.service;

import com.niharika.tutorials.model.Product;
import com.niharika.tutorials.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        List<Product> saveProducts = Arrays.asList(new Product("Niharika","Sam",true));
        productRepository.saveAll(saveProducts);
            productRepository.findAll().forEach(products::add);

        return products;
    }

    public List<Product>  getByProductNameContaining(String name) {
        List<Product> products = new ArrayList<Product>();
        productRepository.findByTitle(name).forEach(products::add);

        return products;
    }

    public Optional<Product> getProductNameById(Long id) {
          return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
         return productRepository.save(new Product(product.getTitle(), product.getDescription(), false));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public List<Product> findByIsAvailable(boolean b) {

        return productRepository.findByIsAvailable(true);
    }
}
