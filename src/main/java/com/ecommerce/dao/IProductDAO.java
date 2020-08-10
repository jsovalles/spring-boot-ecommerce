package com.ecommerce.dao;


import com.ecommerce.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface IProductDAO extends JpaRepository<Product, Integer> {
}
