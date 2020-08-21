package com.bankwithmint.verifycard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class CountryDto {
    String numeric;
    String alpha2;
    String name;
    String emoji;
    String currency;
    int latitude;
    int longitude;
}
