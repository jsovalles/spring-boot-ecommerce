package com.ecommerce.dao;

import com.ecommerce.dao.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface IProductCategoryDAO extends JpaRepository<ProductCategory, Integer> {
}
