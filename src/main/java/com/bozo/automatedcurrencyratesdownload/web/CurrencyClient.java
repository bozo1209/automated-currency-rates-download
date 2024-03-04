package com.bozo.automatedcurrencyratesdownload.web;

import com.bozo.automatedcurrencyratesdownload.enums.Table;
import com.bozo.automatedcurrencyratesdownload.model.Row;

public interface CurrencyClient {
    Row[] getRows(Table table, String startDate, String endDate);
}
