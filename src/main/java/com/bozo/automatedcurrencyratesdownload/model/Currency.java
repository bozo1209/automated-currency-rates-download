package com.bozo.automatedcurrencyratesdownload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    private String currency;
    private String code;
    private BigDecimal mid;

    public Currency(String currency, String code, double mid){
        this(currency, code, BigDecimal.valueOf(mid));
    }

    public void setMid(double mid) {
        this.mid = BigDecimal.valueOf(mid);
    }

    public void setMid(BigDecimal mid){
        this.mid = mid;
    }
}
