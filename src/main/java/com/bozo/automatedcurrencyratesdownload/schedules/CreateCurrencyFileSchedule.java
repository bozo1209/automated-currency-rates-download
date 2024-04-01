package com.bozo.automatedcurrencyratesdownload.schedules;

import com.bozo.automatedcurrencyratesdownload.enums.Table;
import com.bozo.automatedcurrencyratesdownload.service.CreateCurrencyFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateCurrencyFileSchedule {

    private final CreateCurrencyFileService createCurrencyFileService;

    public static final String myCron = "0 0 19 * * *";


    @Async
    @Scheduled(cron = CreateCurrencyFileSchedule.myCron)
    public void createTableAFile(){
        System.out.println("createTableAFile");
        createCurrencyFileService.createCurrencyCSVFile(Table.A, "2024-02-01", "2024-02-29", "table_a");
    }

    @Async
    @Scheduled(cron = CreateCurrencyFileSchedule.myCron)
    public void createTableBFile(){
        System.out.println("createTableBFile");
        createCurrencyFileService.createCurrencyCSVFile(Table.B, "2024-02-01", "2024-02-29", "table_b");
    }

}
