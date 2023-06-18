package io.github.ozzyozbourne.pojos;

import java.math.BigDecimal;

public record OrderLine(String item, int quantity, BigDecimal unitPrice) {

}
