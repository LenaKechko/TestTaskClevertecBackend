package org.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.sale.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}