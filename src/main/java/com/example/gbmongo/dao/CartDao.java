package com.example.gbmongo.dao;

import com.example.gbmongo.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartDao extends MongoRepository<Cart, String> {
}
