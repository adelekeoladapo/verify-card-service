package com.bankwithmint.verifycard.service.impl;

import com.bankwithmint.verifycard.dto.ApiCardResponse;
import com.bankwithmint.verifycard.dto.CardDto;
import com.bankwithmint.verifycard.dto.ServiceResponse;
import com.bankwithmint.verifycard.dto.StatsResponse;
import com.bankwithmint.verifycard.model.Card;
import com.bankwithmint.verifycard.model.repository.CardRepository;
import com.bankwithmint.verifycard.service.CardService;
import com.bankwithmint.verifycard.utils.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "com.ng.vela.even.card_verified";

    @Override
    public ServiceResponse verifyCard(String cardNumber) {
        ServiceResponse response = new ServiceResponse(Message.ERROR, Message.GENERAL_ERROR_MESSAGE);
        ApiCardResponse apiCardResponse = null;
        try {
            apiCardResponse = this.restTemplate.getForObject("https://lookup.binlist.net/" + cardNumber, ApiCardResponse.class);
            if (apiCardResponse != null) {
                response.setPayload(this.generateCardDtoFromApiResponse(apiCardResponse));
                response.setMessage(Message.GENERAL_SUCCESS_MESSAGE);
                new Thread(() -> {
                    this.kafkaTemplate.send(TOPIC, "I just found this card " + cardNumber);
                    this.incrementCardHitCount(cardNumber);
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage(String.format(Message.ERROR_MESSAGE, e.getMessage()));
        }
        return response;
    }

    @Override
    public StatsResponse getStats(int limit, int start) {
        StatsResponse response = new StatsResponse(Message.ERROR, Message.GENERAL_ERROR_MESSAGE);
        try {
            PagedList<Card> cardPagedList = this.cardRepository.list(start, limit);
            response.setLimit(limit);
            response.setStart(start);
            response.setSize(cardPagedList.getTotalCount());
            response.setPayload(cardPagedList.getList().stream().collect(Collectors.toMap(Card::getCardNumber, Card::getHitCount)));
            response.setSuccess(Message.SUCCESS).setMessage(Message.GENERAL_SUCCESS_MESSAGE);
        } catch (Exception e) {
            response.setMessage(String.format(Message.ERROR_MESSAGE, e.getMessage()));
        }
        return response;
    }

    private CardDto generateCardDtoFromApiResponse(ApiCardResponse card) throws Exception {
        CardDto dto = new CardDto();
        dto.setScheme(card.getScheme());
        dto.setBank(card.getBank().getName());
        dto.setType(card.getType());
        return dto;
    }

    private void incrementCardHitCount(String cardNumber) {
        Card card = Optional.ofNullable(this.cardRepository.findByCardNumber(cardNumber)).orElse(new Card());
        card.setCardNumber(cardNumber);
        card.setHitCount(card.getHitCount() + 1);
        this.cardRepository.save(card);
    }

}
