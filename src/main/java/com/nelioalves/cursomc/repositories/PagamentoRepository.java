package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nelioalves.cursomc.domain.*;


@Repository
public interface PagamentoRepository extends JpaRepository <PagamentoDomain, Integer> {

}
