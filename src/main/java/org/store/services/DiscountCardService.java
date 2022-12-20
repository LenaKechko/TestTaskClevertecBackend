package org.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.customer.DiscountCard;
import org.store.repository.DiscountCardRepository;
import org.store.repository.ProductRepository;
import org.store.sale.Product;

import java.util.List;

@Service
public class DiscountCardService {

    @Autowired
    private final DiscountCardRepository discountCardRepository;

    public DiscountCardService(DiscountCardRepository discountCardRepository) {
        this.discountCardRepository = discountCardRepository;
    }

    public List<DiscountCard> findAll() {
        return discountCardRepository.findAll();
    }
}
