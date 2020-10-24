package com.example.demo.service;

import com.example.demo.model.Svc;
import com.example.demo.repository.SvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SvcService {
    private  SvcRepository svcRepository;

    public SvcService(SvcRepository svcRepository) {
        this.svcRepository = svcRepository;
    }

    public List<Svc> getAllSvc() {
        return svcRepository.getAllSvc();
    }

    public Optional<Svc> getSvcById(String id) {
        return svcRepository.getSvcById(id);
    }

//    public int deleteSvc(UUID id) {
//        return svcRepository.deleteSvcById(id);
//    }
}
