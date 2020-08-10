package com.ecommerce.dao;


import com.ecommerce.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface IProductDAO extends JpaRepository<Product, Integer> {

    Page<Product> findByCategoryId(@RequestParam("id") int id, Pageable pageable);
}
