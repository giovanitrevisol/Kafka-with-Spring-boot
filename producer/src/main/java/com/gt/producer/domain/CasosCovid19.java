package com.gt.producer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CasosCovid19 {

    String regiao;
    Long quantidade;
    LocalDate data;

}
