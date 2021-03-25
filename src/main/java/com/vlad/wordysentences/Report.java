package com.vlad.wordysentences;

import com.vlad.wordysentences.exceptions.utils.Utils;

public class Report {
    private int wordsCount;
    private String vowelsConsonantsCount;
    private int largestWordLength;
    private int smallestWordLength;
    private String errorMessage;

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public String getVowelsConsonantsCount() {
        return vowelsConsonantsCount;
    }

    public void setVowelsConsonantsCount(String vowelsConsonantsCount) {
        this.vowelsConsonantsCount = vowelsConsonantsCount;
    }

    public int getLargestWordLength() {
        return largestWordLength;
    }

    public void setLargestWordLength(int largestWordLength) {
        this.largestWordLength = largestWordLength;
    }

    public int getSmallestWordLength() {
        return smallestWordLength;
    }

    public void setSmallestWordLength(int smallestWordLength) {
        this.smallestWordLength = smallestWordLength;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString(){
        return (Utils.isNullOrEmpty(errorMessage))
                ?
                    "{" +
                    "\n\twordCount:" +wordsCount+",\n"+
                    "\tvowelsConsonantsCount:" +vowelsConsonantsCount+",\n"+
                    "\tlargestWordLength:" +largestWordLength+",\n"+
                    "\tsmallestWordLength:" +smallestWordLength+
                    "\n}"
                :
                    "{\n\terrorMessage:"+errorMessage+"\n}";
    }
}
