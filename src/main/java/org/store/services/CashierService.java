package org.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.repository.CashierRepository;
import org.store.sale.Cashier;

import java.util.List;

@Service
public class CashierService {
    @Autowired
    private final CashierRepository cashierRepository;

    public CashierService(CashierRepository cashierRepository) {
        this.cashierRepository = cashierRepository;
    }

    public List<Cashier> findAll() {
        return cashierRepository.findAll();
    }
}
