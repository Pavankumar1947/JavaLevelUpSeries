package com.eclothing.clothing.programming;


import com.eclothing.clothing.entity.Product;
import com.eclothing.clothing.service.impl.ProductServiceImpl;
import com.eclothing.clothing.service.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

//    private final ProductService productService;
//
//    // 200 OK – Get product by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
//        return productService.findById(id)
//                .map(ResponseEntity::ok)          // 200
//                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
//    }
//
//    // 201 CREATED – Create new product
//    @PostMapping
//    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
//        Product savedProduct = productService.save(product);
//        URI location = URI.create("/api/products/" + savedProduct.getId());
//        return ResponseEntity
//                .created(location)
//                .body(savedProduct); // 201
//    }
}

