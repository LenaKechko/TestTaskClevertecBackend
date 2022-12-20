package org.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.customer.DiscountCard;

public interface DiscountCardRepository extends JpaRepository<DiscountCard, Integer> {
}
