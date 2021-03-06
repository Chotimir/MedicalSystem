package com.medicalsystem.service.impl;

import com.medicalsystem.model.Reoperation;
import com.medicalsystem.repository.ReoperationRepository;
import com.medicalsystem.service.ReoperationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReoperationServiceImpl implements ReoperationService {

    private final ReoperationRepository reoperationRepository;

    @Override
    public List<Reoperation> listAll() {
        return reoperationRepository.findAll();
    }

    @Override
    public Reoperation getById(Integer id) {
        return reoperationRepository.findOne(id);
    }

    @Override
    public Reoperation saveOrUpdate(Reoperation reoperation) {
        return reoperationRepository.save(reoperation);
    }

    @Override
    public void delete(Integer id) {
        reoperationRepository.delete(id);
    }
}
