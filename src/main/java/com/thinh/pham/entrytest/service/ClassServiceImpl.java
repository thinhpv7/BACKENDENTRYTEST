package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.ClassRepository;
import com.thinh.pham.entrytest.entity.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{

    private ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Classe> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Classe findById(int theId) {

        Optional<Classe> result = classRepository.findById(theId);

        Classe classe = null;

        if (result.isPresent()) {
            classe = result.get();
        } else {
            throw new RuntimeException("Did not find classe id - " + theId );
        }

        return classe;
    }

    @Override
    public void save(Classe classe) {
        classRepository.save(classe);
    }

    @Override
    public void deleteById(int theId) {
        classRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(Integer theId) {
        return classRepository.existsById(theId);
    }
}
