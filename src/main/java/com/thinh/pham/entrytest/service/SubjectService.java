package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.Subject;

import java.util.List;

public interface SubjectService {

    public List<Subject> findAll();

    public Subject findById(int theId);

    public void save(Subject subject);

    public void deleteById(int theId);

    public boolean existsById(Integer theId);
}
