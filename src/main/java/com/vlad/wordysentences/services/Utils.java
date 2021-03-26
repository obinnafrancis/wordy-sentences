package com.vlad.wordysentences.services;

public class Utils {
    public static boolean isNullOrEmpty(String str){
        return (str==null || str.trim().equals(""));
    }
}
