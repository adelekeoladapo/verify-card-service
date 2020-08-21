package com.bankwithmint.verifycard.model.repository;

import com.bankwithmint.verifycard.model.Card;

public interface CardRepository {

    Card findById(Long id);

    Card findByCardNumber(String cardNumber);

}
