package com.vlad.wordysentences.models;

import com.vlad.wordysentences.exceptions.WordOnlyValidationException;
import com.vlad.wordysentences.services.Utils;

public class CreateLogRequest {
    private int staffId;

    public CreateLogRequest(){}

    public CreateLogRequest(String staffId){
        if(Utils.isNullOrEmpty(staffId)){
            throw new WordOnlyValidationException("argument cannot be null");
        }
        this.staffId = Integer.parseInt(staffId);
    }
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}
