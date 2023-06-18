package io.github.ozzyozbourne.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ELEMENT_NAME", "TYPE", "LOCATOR_VALUE"})
public record CsvRec(@JsonProperty(value = "ELEMENT_NAME")  String elementName,
                     @JsonProperty(value = "TYPE")          String type,
                     @JsonProperty(value = "LOCATOR_VALUE") String locatorValue) {}
