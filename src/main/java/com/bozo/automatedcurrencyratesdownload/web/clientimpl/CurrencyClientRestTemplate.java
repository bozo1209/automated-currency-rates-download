package com.bozo.automatedcurrencyratesdownload.web.clientimpl;

import com.bozo.automatedcurrencyratesdownload.enums.Table;
import com.bozo.automatedcurrencyratesdownload.model.Row;
import com.bozo.automatedcurrencyratesdownload.web.CurrencyClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CurrencyClientRestTemplate implements CurrencyClient {
    @Value("${nbp.api.host}")
    private String apiHost;

    @Value("${nbp.api.table}")
    private String tablePath;

    private final RestTemplate restTemplate;


    public CurrencyClientRestTemplate(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder
                .build();
    }

    @Override
    public Row[] getRows(Table table, String startDate, String endDate){
        return restTemplate
                .getForObject(
                        apiHost + tablePath,
                        Row[].class,
                        Map.of("table", table, "startDate", startDate, "endDate", endDate));
    }

}
