package io.github.ozzyozbourne.pojos.yaml;

import java.math.BigDecimal;

public record OrderLine(String item, int quantity, BigDecimal unitPrice) {

}
