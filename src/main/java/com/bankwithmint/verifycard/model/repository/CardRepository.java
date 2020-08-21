package com.bankwithmint.verifycard.model.repository;

import com.bankwithmint.verifycard.model.Card;

public interface CardRepository {

    Card save(Card card);

    Card findById(Long id);

    Card findByCardNumber(String cardNumber);

}
