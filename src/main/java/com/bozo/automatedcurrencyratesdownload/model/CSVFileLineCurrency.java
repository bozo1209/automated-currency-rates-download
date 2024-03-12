package com.bozo.automatedcurrencyratesdownload.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CSVFileLineCurrency {

    @CsvBindByName
    private String no;

    @CsvBindByName
    private String effectiveDate;

    @CsvBindByName
    private String currency;

    @CsvBindByName
    private String code;

    @CsvBindByName(locale = "pl-PL")
    @CsvNumber("#,##########")
    private BigDecimal mid;

}
