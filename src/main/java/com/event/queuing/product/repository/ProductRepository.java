package com.event.queuing.product.repository;


import com.event.queuing.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
