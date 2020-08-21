package com.bankwithmint.verifycard.service;

import com.bankwithmint.verifycard.dto.ServiceResponse;

public interface CardService {

    ServiceResponse verifyCard(String cardNumber);

}
