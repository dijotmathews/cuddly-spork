package com.dijo.tc;

import java.math.BigDecimal;

record ProductPriceChangedEvent(String productCode, BigDecimal price) {}