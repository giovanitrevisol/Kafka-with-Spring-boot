package com.gt.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gt.producer.domain.CasosCovid19;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CasosCovid19Service {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public void enviarCasosCovid19(CasosCovid19 casosCovid19){

        try {
            casosCovid19.setData(LocalDate.now());

            //aqui poderiamos mandar o objeto sem converter para string
            String casosCovid19String = objectMapper.writeValueAsString(casosCovid19);
            kafkaTemplate.send("covid", casosCovid19String);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
