package com.homeease.service.repository;

import com.homeease.service.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findCartByUserId(Long userId);
}
