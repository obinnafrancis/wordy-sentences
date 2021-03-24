package com.vlad.wordysentences;

import com.vlad.wordysentences.exceptions.WordOnlyValidationException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusinessLogicService {
    Collection<String> collection;
    Map<String,String> response = new HashMap<>();

    public Map<String, String> processData(String wordText, String sentenceText) {

        try {
            getCollection(sentenceText);
            validateWordArgument(wordText);
            validateSentenceArgument(sentenceText);
            response = validProcessing(wordText,sentenceText);
        }catch (WordOnlyValidationException e){
            response.put("Response",e.getMessage());
        }
        return response;
    }

    private Map<String, String> validProcessing(String word,String sentenceText) {
        Map<String,String> response = new HashMap<>();
        response.put("wordsCount",String.valueOf(collection.size()));
        response.put("vowelsConsonantCount",getVowelsAndConsonantsInWord(word));
        response.put("largestWordLength",String.valueOf(getLargestWordLength()));
        response.put("smallestWordLength",String.valueOf(getSmallestWordLength()));
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
        response = new HashMap<>();
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
