package com.diogo.santander.repository;

import com.diogo.santander.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ContaRepository extends JpaRepository<ContaCorrente, Integer> {

    @Query(value = "SELECT count(*) FROM conta_corrente WHERE numero = ?1", nativeQuery = true)
    int validaNumConta(int numeroConta);

    @Query(value = "SELECT saldo FROM conta_corrente WHERE numero = ?1", nativeQuery = true)
    double buscaSaldo(int numeroConta);

    @Modifying
    @Query(value = "UPDATE conta_corrente SET saldo = ?1 WHERE numero = ?2", nativeQuery = true)
    void atualizarSaldo(double saldoAtualizado, int numeroConta);
}
