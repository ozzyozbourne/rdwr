package io.github.ozzyozbourne.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Prop(String name, String age, String height) {
}
