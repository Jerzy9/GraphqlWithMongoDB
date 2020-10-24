package com.example.demo.repository;

import com.example.demo.model.Svc;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fake")
public class FakeSvcRepository implements SvcRepository {
    private List<Svc> listOfSvc = Arrays.asList(
            new Svc("1", "name", "disc", 2, "d"),
            new Svc("1", "name", "disc", 2, "d")
    );


    @Override
    public List<Svc> getAllSvc() {
        return listOfSvc;
    }

    @Override
    public Optional<Svc> getSvcById(String id) {
        return listOfSvc.stream().filter(svc -> svc.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteSvcById(UUID id) {
        return 0;
    }
}
