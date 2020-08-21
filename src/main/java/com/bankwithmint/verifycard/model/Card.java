package com.bankwithmint.verifycard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
