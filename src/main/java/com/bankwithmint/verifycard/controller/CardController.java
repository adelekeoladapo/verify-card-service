package com.bankwithmint.verifycard.controller;

import com.bankwithmint.verifycard.dto.ServiceResponse;
import com.bankwithmint.verifycard.service.CardService;
import com.bankwithmint.verifycard.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/stats", method = RequestMethod.GET)
    public ServiceResponse getStats(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int limit) {
        ServiceResponse response = new ServiceResponse(false, Message.GENERAL_ERROR_MESSAGE);
        if (start < 1 || limit < 1) {
            return response.setMessage(String.format(Message.ERROR_MESSAGE, "Start or Limit can not be less than 1"));
        }
        try {
            return this.cardService.getStats(limit, start);
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }

}
