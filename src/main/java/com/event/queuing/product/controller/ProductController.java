package com.event.queuing.product.controller;

import com.event.queuing.product.entity.Product;
import com.event.queuing.product.service.ProductService;
import com.event.queuing.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @PostMapping("/publish")
//    public String publishMessage(@RequestBody Product product) {
//        this.productService.publishMessage(product);
//        return "Successfully published message";
//    }

    @PostMapping("/save")
    public String saveProduct() {
        this.productService.saveProduct();
        return "Saved product";
    }

    @PostMapping("/bulk-save")
    public String bulkSaveProduct() {
//        this.productService.saveProduct();
        this.productService.bulkSaveProduct();
        return "Bulk Saved product";
    }

}
