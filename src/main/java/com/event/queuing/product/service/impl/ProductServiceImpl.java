package com.event.queuing.product.service.impl;

import com.event.queuing.product.entity.Product;
import com.event.queuing.product.entity.ProductCategory;
import com.event.queuing.product.repository.ProductRepository;
import com.event.queuing.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct() {
        Product product = new Product();
        product.setName("Test1");
        product.setQuantity(100L);
        product.setPrice(999.00);
        ProductCategory pc = new ProductCategory();
        pc.setCategoryName("Clothes");
        pc.setCode("ABC1045");
        product.setProductCategory(pc);
        this.productRepository.save(product);
    }

}
