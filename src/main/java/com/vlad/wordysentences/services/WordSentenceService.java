package com.vlad.wordysentences.services;

import com.vlad.wordysentences.models.Report;
import com.vlad.wordysentences.exceptions.WordOnlyValidationException;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordSentenceService {
    Collection<String> collection;


    public Report processData(String wordText, String sentenceText) {
        Report response = new Report();
        try {
            baseValidation(wordText,sentenceText);
            getCollection(sentenceText);
            validateWordArgument(wordText);
            validateSentenceArgument(sentenceText);
            response = validProcessing(wordText,response);
        }catch (WordOnlyValidationException e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    private void baseValidation(String wordText, String sentenceText) {
        if(Utils.isNullOrEmpty(wordText) || Utils.isNullOrEmpty(sentenceText)){
            throw new WordOnlyValidationException("Arguments should not be empty");
        }
    }

    private Report validProcessing(String word,Report response) {
        response.setWordsCount(collection.size());
        response.setVowelsConsonantsCount(getVowelsAndConsonantsInWord(word));
        response.setLargestWordLength(getLargestWordLength());
        response.setSmallestWordLength(getSmallestWordLength());
        return response;
    }

    private String getVowelsAndConsonantsInWord(String word){
        int wordLength = word.length();
        int vowelCount = getVowelCount(word);
        int consonantCount = wordLength - vowelCount;
        return String.format("Number of vowels is %d and the number of consonants is %d",vowelCount,consonantCount);
    }

    private int getLargestWordLength(){
        List<String> unsortedList = collection.stream().collect(Collectors.toList());
        unsortedList.sort(Comparator.comparing(String::length));
        return unsortedList.get(collection.size()-1).length();
    }

    private int getSmallestWordLength(){
        List<String> unsortedList = collection.stream().collect(Collectors.toList());
        unsortedList.sort(Comparator.comparing(String::length));
        return unsortedList.get(0).length();
    }

    public void reset(){
        collection = new ArrayList<>();
    }


    /**
     *
     * @param word
     * @return  count of vowel
     */
    private int getVowelCount(String word) {
        String vowels = "aeiou";
        String[] wordsArray = word.split("");
        int count =0;
        for (String ch:wordsArray){
            if(vowels.contains(ch.toLowerCase())){
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param word
     * This valiates the word argument
     */
    private void validateWordArgument(String word){
        if (!isValidWordCharacterLength(word)){
           throw new WordOnlyValidationException("Error");
        }
    }

    /**
     *
     * @param sentence
     * This valiates the sentence argument
     */
    private void validateSentenceArgument(String sentence){
        if(!isValidWordCount(sentence)){
            throw new WordOnlyValidationException(String.format("%d words found in sentence argument. Min should be 5 and Max should be 30",collection.size()));
        }
        int index = 0;
        for(String word:collection){
            index++;
            if(!isValidWordCharacterLength(word)){
                throw new WordOnlyValidationException(String.format("The word %s in position %d of sentence argument failed the test",word,index));
            }
        }
    }

    /**
     *
     * @param sentence
     * @return the number of words in the sentence argument
     */
    private int getWordCountInSentence(String sentence){
//        Collection<String> collection = getCollection(sentence);
        return collection.size();
    }

    /**
     *
     * @param sentence
     * @return a collection of words in the sentence argument
     */
    private Collection<String> getCollection(String sentence){
        List<String> splitted = Arrays.asList(sentence.split("\\s* \\s*"));
        collection = Arrays.asList(sentence.split("\\s* \\s*"));
        return collection;
    }

    /**
     *
     * @param sentence
     * @return true if number of words in the sentence argument is not less than 5 or greater than 30
     */
    private boolean isValidWordCount(String sentence){
        int count = getWordCountInSentence(sentence);
        return (count>=5 && count<=30);
    }

    /**
     *
     * @param word
     * @return false if the number of characters in a word is greater than 8
     */
    private boolean isValidWordCharacterLength(String word){
        int count = word.length();
        return count <= 8;
    }
}
