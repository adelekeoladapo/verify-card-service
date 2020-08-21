package com.bankwithmint.verifycard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class CardDto {
    String scheme;
    String type;
    String bank;
}
