package io.github.ozzyozbourne.pojos.toml;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.ozzyozbourne.pojos.yaml.OrderLine;

import java.time.LocalDate;
import java.util.List;


public record Order(@JsonProperty(value = "ORDER_NO") String orderNo,
                    LocalDate date,
                    String customerName) {}
