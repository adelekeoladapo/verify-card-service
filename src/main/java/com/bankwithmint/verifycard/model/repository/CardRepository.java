package com.bankwithmint.verifycard.model.repository;

import com.bankwithmint.verifycard.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CardRepository extends PagingAndSortingRepository<Card, Long> {

    Card findByCardNumber(String cardNumber);
//
////    PagedList<Card> list(int start, int limit);

}
