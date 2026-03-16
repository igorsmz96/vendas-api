package com.vendas.api.repositories;

import com.vendas.api.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddreesRepository extends JpaRepository<Address, Long> {
}
