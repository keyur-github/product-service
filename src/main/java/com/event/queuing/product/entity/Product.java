package com.event.queuing.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private Double price;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "product_category_id", referencedColumnName = "id", unique = true)
    private ProductCategory productCategory;

}
