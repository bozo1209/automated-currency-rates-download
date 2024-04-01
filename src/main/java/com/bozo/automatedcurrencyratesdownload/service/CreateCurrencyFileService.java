package com.bozo.automatedcurrencyratesdownload.service;

import com.bozo.automatedcurrencyratesdownload.enums.Table;
import com.bozo.automatedcurrencyratesdownload.mapper.CSVFileLineCurrencyMapper;
import com.bozo.automatedcurrencyratesdownload.model.CSVFileLineCurrency;
import com.bozo.automatedcurrencyratesdownload.model.Row;
import com.bozo.automatedcurrencyratesdownload.web.CurrencyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateCurrencyFileService {

    private final CurrencyClient currencyClient;
    private final CSVService csvService;
    private final CSVFileLineCurrencyMapper csvFileLineCurrencyMapper;

    public void createCurrencyCSVFile(Table table, String startDate, String endDate, String fileName){
        Row[] rows = currencyClient.getRows(table, startDate, endDate);
        List<CSVFileLineCurrency> csvFileLineCurrencies = csvFileLineCurrencyMapper.rowsToCSVFileLineCurrencyMapper(rows);
        csvService.saveAsCSV(csvFileLineCurrencies, fileName);
    }

}
