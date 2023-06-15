package io.github.ozzyozbourne.pojos.yaml;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;


public record Order(@JsonProperty(value = "ORDER_NO") String orderNo,
                    LocalDate date,
                    String customerName,
                    List<OrderLine> orderLines) {}
