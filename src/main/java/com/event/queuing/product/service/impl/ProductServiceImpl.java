package com.event.queuing.product.service.impl;

import com.event.queuing.product.entity.Product;
import com.event.queuing.product.entity.ProductCategory;
import com.event.queuing.product.repository.ProductRepository;
import com.event.queuing.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;

@Service
@Slf4j
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

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void bulkSaveProduct() {
        LinkedList<Product> products = new LinkedList<>();
        try {
            for (int i = 1; i <= 10; i++) {
                Product product = new Product();
                product.setName("Test_" + i);
                product.setQuantity(i * 10L);
                product.setPrice(99D * i);
                this.productRepository.saveAndFlush(product);
                if (i == 7) {
                    throw new RuntimeException("Something went wrong");
                }
            }
        } catch (RuntimeException e) {
            log.info("Error :: {}", e.getMessage());
            throw e;
        }
    }

}
