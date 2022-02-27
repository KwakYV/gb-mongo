package com.example.gbmongo.controller;

import com.example.gbmongo.model.Cart;
import com.example.gbmongo.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Cart> getCarts() {
        return cartService.findAll();
    }

    @GetMapping("/{cart_id}")
    public Cart findById(@PathVariable("cart_id") String id) {
        return cartService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Validated @RequestBody Cart cart) {
        Cart saved = cartService.save(cart);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{cart_id}")
    public ResponseEntity<?> handlePut(@Validated @RequestBody Cart cart, @PathVariable("cart_id") String id) {
        cart.setId(id);
        Cart saved = cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{cart_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("cart_id") String id) {
        cartService.delete(id);
    }
}
