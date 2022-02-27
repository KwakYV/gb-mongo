package com.example.gbmongo.service;

import com.example.gbmongo.dao.CartDao;
import com.example.gbmongo.model.Cart;
import com.example.gbmongo.model.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {
    private final CartDao cartDao;

    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    public Cart save(Cart cart) {
        return cartDao.save(cart);
    }

    public Cart findById(String id) {
        return cartDao.findById(id).orElse(null);
    }

    public void delete(String id) {
        cartDao.deleteById(id);
    }
}
