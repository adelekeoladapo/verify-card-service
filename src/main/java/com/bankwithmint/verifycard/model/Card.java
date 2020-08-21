package com.bankwithmint.verifycard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Setter @Getter
public class Card {
    Long id;
    String cardNumber;
    @Enumerated(EnumType.STRING)
    CardType type;
    @ManyToOne
    Scheme scheme;
    @ManyToOne
    Bank bank;
    @ManyToOne
    Country country;
}
