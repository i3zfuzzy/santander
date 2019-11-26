package com.diogo.santander.repository;

import com.diogo.santander.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaCorrente, Integer> {
}
