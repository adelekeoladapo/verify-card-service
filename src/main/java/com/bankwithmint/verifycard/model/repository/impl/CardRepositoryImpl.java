package com.bankwithmint.verifycard.model.repository.impl;

import com.bankwithmint.verifycard.model.Card;
import com.bankwithmint.verifycard.model.repository.CardRepository;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepositoryImpl implements CardRepository {

    @Autowired
    EbeanServer store;

    @Override
    public Card findById(Long id) {
        return this.store.find(Card.class).where().idEq(id).findOne();
    }

    @Override
    public Card findByCardNumber(String cardNumber) {
        return this.store.find(Card.class).where().eq("cardNumber", cardNumber).findOne();
    }
}
