package com.bankwithmint.verifycard.service.impl;

import com.bankwithmint.verifycard.dto.CardDto;
import com.bankwithmint.verifycard.dto.ServiceResponse;
import com.bankwithmint.verifycard.model.Card;
import com.bankwithmint.verifycard.model.repository.CardRepository;
import com.bankwithmint.verifycard.service.CardService;
import com.bankwithmint.verifycard.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public ServiceResponse verifyCard(String cardNumber) {
        ServiceResponse response = new ServiceResponse(Message.ERROR, Message.GENERAL_ERROR_MESSAGE);
        Card card = this.cardRepository.findByCardNumber(cardNumber);
        if (Objects.nonNull(card)) {
            try {
                response.setPayload(this.generateCardDtoFromCard(card));
                response.setMessage(Message.GENERAL_SUCCESS_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                response.setMessage(String.format(Message.ERROR_MESSAGE, e));
            }
        } else {
            response.setMessage(String.format(Message.NOT_FOUND_MESSAGE, "Card"));
        }
        return response;
    }

    private CardDto generateCardDtoFromCard(Card card) throws Exception {
        CardDto dto = new CardDto();
        dto.setScheme(card.getScheme().getName());
        dto.setBank(card.getBank().getName());
        dto.setType(card.getType().toString());
        return dto;
    }
}
