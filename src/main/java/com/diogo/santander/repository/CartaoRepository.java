package com.diogo.santander.repository;

import com.diogo.santander.model.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoCredito, Long> {

    @Query(value = "SELECT limite FROM cartao_credito WHERE numero = ?1", nativeQuery = true)
    double consultaLimite(String numeroCartao);


    @Modifying
    @Transactional
    @Query(value = "UPDATE cartao_credito SET limite = ?2, fatura = ?3 WHERE numero = ?1", nativeQuery = true)
    void atualizaLimiteFatura(String numeroCartao, double limiteAtualizado, double valor);

}
