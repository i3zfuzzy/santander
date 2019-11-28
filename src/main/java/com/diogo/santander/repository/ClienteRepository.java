package com.diogo.santander.repository;

import com.diogo.santander.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    List<Cliente> listarClientes();

}
