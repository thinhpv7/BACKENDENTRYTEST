package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Subject;

import java.util.List;

public interface PartService {

    public List<Part> findAll();

    public Part findById(int theId);

    public void save(Part part);

    public void deleteById(int theId);

    public boolean existsById(Integer theId);

    public List<Part> findBySubject(Subject subject);
}
