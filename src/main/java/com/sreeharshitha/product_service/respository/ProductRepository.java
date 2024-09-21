package com.sreeharshitha.product_service.respository;


import com.sreeharshitha.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
