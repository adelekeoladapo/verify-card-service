package com.bankwithmint.verifycard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {
    public boolean success;
    public String message;
    public Object payload;

    public ServiceResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }


    public static ServiceResponse newErrorResponse(String message){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setSuccess(false);
        serviceResponse.setMessage(message);
        return serviceResponse;
    }

    public static ServiceResponse newSuccessResponse(String message){
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setSuccess(true);
        serviceResponse.setMessage(message);
        return serviceResponse;
    }


}
