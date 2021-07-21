package com.gt.consumer.Controller.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gt.consumer.domain.CasosCovid19;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CasosCovidController {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "covid")
    public void lerCasosCovid19(final String mensagem){
        try {
            CasosCovid19 casos =  objectMapper.readValue(mensagem, CasosCovid19.class);
            System.out.println(casos.toString());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
