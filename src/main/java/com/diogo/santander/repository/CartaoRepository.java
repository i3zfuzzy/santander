package com.diogo.santander.repository;

import com.diogo.santander.model.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoCredito, Long> {
}
