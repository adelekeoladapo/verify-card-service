package com.bankwithmint.verifycard.service;

import com.bankwithmint.verifycard.dto.ServiceResponse;
import com.bankwithmint.verifycard.dto.StatsResponse;

public interface CardService {

    ServiceResponse verifyCard(String cardNumber);

    StatsResponse getStats(int limit, int start);

}
