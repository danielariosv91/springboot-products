package com.drios.springboot.di.app.springboot_di.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drios.springboot.di.app.springboot_di.models.Product;
import com.drios.springboot.di.app.springboot_di.services.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class SomeController {

    // Genera un problema de mutabilidad se crea una nueva instancia en el servicio
    private ProductServiceImpl service = new ProductServiceImpl();

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
}
