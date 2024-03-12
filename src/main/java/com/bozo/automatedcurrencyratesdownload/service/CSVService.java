package com.bozo.automatedcurrencyratesdownload.service;

import com.bozo.automatedcurrencyratesdownload.model.CSVFileLineCurrency;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

@Service
public class CSVService {

    @Value("${save.path.directory}")
    private String mainDirectory;

    public void saveAsCSV(List<CSVFileLineCurrency> lines){
        String fileName = mainDirectory + "\\myCSV.csv";
        try(Writer writer = new FileWriter(fileName)) {
            StatefulBeanToCsv<CSVFileLineCurrency> beanToCsv = new StatefulBeanToCsvBuilder<CSVFileLineCurrency>(writer)
                    .withApplyQuotesToAll(false)
                    .withSeparator(';')
                    .build();
            beanToCsv.write(lines);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("end saving");
    }
}
