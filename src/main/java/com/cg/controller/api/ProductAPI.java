package com.cg.controller.api;

import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.service.category.ICategoryService;
import com.cg.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductAPI {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if(product.getId() != null) {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        List<Product> products = (List<Product>) productService.findAll();
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
