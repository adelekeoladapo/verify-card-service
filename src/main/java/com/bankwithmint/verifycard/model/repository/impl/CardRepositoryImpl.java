package com.bankwithmint.verifycard.model.repository.impl;

import com.bankwithmint.verifycard.model.Card;
import com.bankwithmint.verifycard.model.repository.CardRepository;
import io.ebean.EbeanServer;
import io.ebean.ExpressionList;
import io.ebean.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    @Autowired
    EbeanServer store;

    @Override
    public Card save(Card card) {
        this.store.save(card);
        return card;
    }

    @Override
    public Card findById(Long id) {
        return this.store.find(Card.class).where().idEq(id).findOne();
    }

    @Override
    public Card findByCardNumber(String cardNumber) {
        return this.store.find(Card.class).where().eq("cardNumber", cardNumber).findOne();
    }

    @Override
    public PagedList<Card> list(int start, int limit) {
        return this.store.find(Card.class).setFirstRow(start - 1).setMaxRows(limit).findPagedList();
    }
}
