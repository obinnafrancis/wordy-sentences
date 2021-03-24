package com.vlad.wordysentences.exceptions;

public class WordOnlyValidationException extends RuntimeException {
    public WordOnlyValidationException(String message){
        super(message);
    }
}
