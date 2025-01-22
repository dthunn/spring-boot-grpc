package com.trading.aggregator.dto;

public record PriceUpdateDto(String ticker,
                             Integer price) {
}
