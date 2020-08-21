package com.bankwithmint.verifycard.model.repository.impl;

import com.bankwithmint.verifycard.model.Card;
import com.bankwithmint.verifycard.model.repository.CardRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepositoryImpl implements CardRepository {

    @Override
    public Card save(Card card) {
        return null;
    }

    @Override
    public Card findById(Long id) {
        return null;
    }

    @Override
    public Card findByCardNumber(String cardNumber) {
        return null;
    }
}
