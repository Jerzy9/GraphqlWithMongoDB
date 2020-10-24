package com.example.demo.repository;

import com.example.demo.model.Svc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SvcRepository {

    List<Svc> getAllSvc();

    Optional<Svc> getSvcById(UUID id);

    int deleteSvcById(UUID id);
}
