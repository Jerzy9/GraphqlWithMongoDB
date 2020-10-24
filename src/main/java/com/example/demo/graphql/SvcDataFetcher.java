package com.example.demo.graphql;

import com.example.demo.service.SvcService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SvcDataFetcher {

    private SvcService svcService;

    @Autowired
    public SvcDataFetcher(SvcService svcService) {
        this.svcService = svcService;
    }

    public DataFetcher getAllSvc() {
        return dataFetchingEnvironment -> svcService.getAllSvc();
    }

    public DataFetcher getSvcById() {
        return dataFetchingEnvironment -> svcService.getSvcById(dataFetchingEnvironment.getArgument("asdads"));
    }

}
