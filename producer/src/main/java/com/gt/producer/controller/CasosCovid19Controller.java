package com.gt.producer.controller;

import com.gt.producer.domain.CasosCovid19;
import com.gt.producer.service.CasosCovid19Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class CasosCovid19Controller {

    private final CasosCovid19Service service;

    @PostMapping(value = "/post")
    public void postCasosCovid19(@RequestBody CasosCovid19 casosCovid19){
        service.enviarCasosCovid19(casosCovid19);
    }
}
