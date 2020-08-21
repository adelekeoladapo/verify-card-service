package com.bankwithmint.verifycard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CardDto {
    String scheme;
    String type;
    String bank;
}
