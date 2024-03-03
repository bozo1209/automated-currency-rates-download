package com.bozo.automatedcurrencyratesdownload.web;

import com.bozo.automatedcurrencyratesdownload.model.Row;

public interface CurrencyClient {
    Row[] getRows(String table, String startDate, String endDate);
}
