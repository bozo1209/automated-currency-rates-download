package com.bozo.automatedcurrencyratesdownload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Row {
    private String table;
    private String no;
    private String effectiveDate;
    private List<Currency> rates;
}
