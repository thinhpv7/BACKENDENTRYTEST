package com.thinh.pham.entrytest.service;

import com.thinh.pham.entrytest.dao.PartRepository;
import com.thinh.pham.entrytest.entity.Part;
import com.thinh.pham.entrytest.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {

    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        return partRepository.findAll();
    }

    @Override
    public Part findById(int theId) {
        Optional<Part> result = partRepository.findById(theId);

        Part thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        } else {
            throw new RuntimeException("Did not find part id - " + theId);
        }
        return thePart;
    }

    @Override
    public void save(Part part) {
        partRepository.save(part);
    }

    @Override
    public void deleteById(int theId) {
        partRepository.deleteById(theId);
    }

    @Override
    public boolean existsById(Integer theId) {
        return partRepository.existsById(theId);
    }

    @Override
    public List<Part> findBySubject(Subject subject) {
        return partRepository.findBySubject(subject);
    }
}
