package com.vlad.wordysentences;

public class Report {
    private int wordsCount;
    private int vowelsCount;
    private int largestWordLength;
    private int smallestWordLength;

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public int getVowelsCount() {
        return vowelsCount;
    }

    public void setVowelsCount(int vowelsCount) {
        this.vowelsCount = vowelsCount;
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
}
