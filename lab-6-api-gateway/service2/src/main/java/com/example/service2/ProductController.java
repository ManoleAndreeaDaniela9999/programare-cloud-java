package com.example.service2;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private List<Product> products = new ArrayList<Product>();

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void create(@RequestBody Product product, BindingResult result) {
        if(result.hasErrors())
            throw new RuntimeException("Product creation exception");
        products.add(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return products;
    }
}
