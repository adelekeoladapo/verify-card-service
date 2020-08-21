package com.bankwithmint.verifycard.model.repository;

import com.bankwithmint.verifycard.model.Card;

import java.util.List;

public interface CardRepository {

    Card save(Card card);

    Card findById(Long id);

    Card findByCardNumber(String cardNumber);

//    PagedList<Card> list(int start, int limit);

}
