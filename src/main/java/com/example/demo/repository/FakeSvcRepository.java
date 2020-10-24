package com.example.demo.repository;

import com.example.demo.model.Svc;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class FakeSvcRepository implements SvcRepository {
    private List<Svc> listOfSvc = new ArrayList<>();

    @Override
    public List<Svc> getAllSvc() {
        return listOfSvc;
    }

    @Override
    public Optional<Svc> getSvcById(UUID id) {
        return listOfSvc.stream().filter(svc -> svc.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteSvcById(UUID id) {
        return 0;
    }
}
