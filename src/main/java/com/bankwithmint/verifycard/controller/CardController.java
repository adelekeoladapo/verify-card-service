package com.bankwithmint.verifycard.controller;

import com.bankwithmint.verifycard.dto.ServiceResponse;
import com.bankwithmint.verifycard.service.CardService;
import com.bankwithmint.verifycard.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card-scheme")
public class CardController {

    @Autowired
    CardService cardService;

    @RequestMapping(path = "/verify/{cardNumber}", method = RequestMethod.GET)
    public ServiceResponse findById(@PathVariable("cardNumber") String cardNumber) {
        ServiceResponse response = new ServiceResponse(false, Message.GENERAL_ERROR_MESSAGE);
        try {
            return this.cardService.verifyCard(cardNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }

}
