package com.bankwithmint.verifycard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class NumberDto {
    int length;
    boolean luhn;
}
