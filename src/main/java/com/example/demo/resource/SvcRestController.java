package com.example.demo.resource;

import com.example.demo.repository.SvcRepository;
import com.example.demo.service.SvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/rest/svc"})
public class SvcRestController {

//    private final SvcService svcService;
//
//    @Autowired
//    public SvcRestController(SvcService svcService) {
//        this.svcService = svcService;
//    }
//



}
