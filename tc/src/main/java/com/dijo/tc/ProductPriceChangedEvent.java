package com.dijo.tc;

import java.math.BigDecimal;

public record ProductPriceChangedEvent(String productCode, BigDecimal price) {
}
