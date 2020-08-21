package com.bankwithmint.verifycard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class StatsResponse extends ServiceResponse {
    int start;
    int limit;
    int size;
    public StatsResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }
}
