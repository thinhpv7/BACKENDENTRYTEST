package com.thinh.pham.entrytest.dao;

import com.thinh.pham.entrytest.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classe, Integer> {
}
