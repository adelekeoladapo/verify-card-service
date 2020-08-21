package com.bankwithmint.verifycard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ApiCardResponse {
    NumberDto number;
    String scheme;
    String type;
    String brand;
    String prepaid;
    CountryDto country;
    BankDto bank;
}




