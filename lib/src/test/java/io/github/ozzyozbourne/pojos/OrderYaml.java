package io.github.ozzyozbourne.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;


public record OrderYaml(@JsonProperty(value = "ORDER_NO") String orderNo,
                        LocalDate date,
                        String customerName,
                        List<OrderLine> orderLines) {}
