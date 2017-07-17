package com.medicalsystem.service.impl;

import com.medicalsystem.model.Smoking;
import com.medicalsystem.repository.SmokingRepository;
import com.medicalsystem.service.SmokingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SmokingServiceImpl implements SmokingService {

    private final SmokingRepository smokingRepository;

    @Override
    public List<Smoking> listAll() {
        return smokingRepository.findAll();
    }

    @Override
    public Smoking getById(Integer id) {
        return smokingRepository.findOne(id);
    }

    @Override
    public Smoking saveOrUpdate(Smoking smoking) {
        return smokingRepository.save(smoking);
    }

    @Override
    public void delete(Integer id) {
        smokingRepository.delete(id);
    }

    @Override
    public int getSmokingIdByText(String text) {
        return smokingRepository.findByText(text).getId();
    }

}
