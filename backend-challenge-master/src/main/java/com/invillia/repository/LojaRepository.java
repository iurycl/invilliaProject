package com.invillia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.invillia.classe.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {

	Loja findOne(Long ljid);

}
