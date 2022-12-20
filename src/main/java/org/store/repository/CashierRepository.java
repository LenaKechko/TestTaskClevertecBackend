package org.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.sale.Cashier;

public interface CashierRepository extends JpaRepository<Cashier, Integer> {

}
