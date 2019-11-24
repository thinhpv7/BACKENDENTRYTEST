package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.Classe;

import java.util.List;

public interface ClassService {

    public List<Classe> findAll();

    public Classe findById(int theId);

    public void save(Classe classe);

    public void deleteById(int theId);

    boolean existsById(Integer theId);
}
