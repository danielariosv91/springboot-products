package com.drios.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.drios.springboot.di.app.springboot_di.models.Product;
import com.drios.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    public List<Product> findAll() {
        return repository.findAll().stream().map(item -> {
            Double priceWithTax = item.getPrice() * 1.25d;

            Product newProduct = (Product) item.clone();
            newProduct.setPrice(priceWithTax.longValue());

            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
