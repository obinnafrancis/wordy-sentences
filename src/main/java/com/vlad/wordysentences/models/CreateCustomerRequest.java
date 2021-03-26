package com.vlad.wordysentences.models;

import com.vlad.wordysentences.exceptions.WordOnlyValidationException;
import com.vlad.wordysentences.services.Utils;

public class CreateCustomerRequest {
    private String name;

    public CreateCustomerRequest(){}
    public CreateCustomerRequest(String name){
        if(Utils.isNullOrEmpty(name)){
            throw new WordOnlyValidationException("argument cannot be null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
