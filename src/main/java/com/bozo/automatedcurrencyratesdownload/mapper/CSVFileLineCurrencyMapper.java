package com.bozo.automatedcurrencyratesdownload.mapper;

import com.bozo.automatedcurrencyratesdownload.model.CSVFileLineCurrency;
import com.bozo.automatedcurrencyratesdownload.model.Row;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CSVFileLineCurrencyMapper {

    public List<CSVFileLineCurrency> rowsToCSVFileLineCurrencyMapper(Row[] rows){
        return Arrays
                .stream(rows)
                .flatMap(row ->
                        row
                            .getRates()
                            .stream()
                            .map(rate ->
                                CSVFileLineCurrency
                                        .builder()
                                        .no(row.getNo())
                                        .effectiveDate(row.getEffectiveDate())
                                        .currency(rate.getCurrency())
                                        .code(rate.getCode())
                                        .mid(rate.getMid())
                                        .build()))
                .toList();
    }
}
