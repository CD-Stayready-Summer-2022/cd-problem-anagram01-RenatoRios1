package com.codedifferently;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram01 {

    public static String[] problem(String inputWord, String[] inputWordList){
        //we need a HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        //we need a return Array
        List<String> returnList = new ArrayList<>();
        //we need to add every character form inputWord into that hashmap
        for(int i = 0; i < inputWord.length(); i++){
            if(!map.containsKey(inputWord.charAt(i))){
                map.put(inputWord.charAt(i), 1);
            }else{
                map.put(inputWord.charAt(i), map.get(inputWord.charAt(i))+1);
            }
        }
        //Then we need iterate through every element in inputWordList
         for(String each: inputWordList){
             HashMap<Character, Integer> tempMap = (HashMap<Character, Integer>) map.clone();
            //iterate through every character in element
             for(int i = 0; i < each.length(); i++){
                //Check to see if that character is in the HashMap
                 if(tempMap.containsKey(each.charAt(i)) && tempMap.get(each.charAt(i)) != 0){
                     //IF TRUE AND value is NOT equal to 0
                     //Then Decrease the value of that key
                     tempMap.put(each.charAt(i), tempMap.get(each.charAt(i))-1);

                }else{
                    //IF False
                    //BREAK
                     break;
                }
                 //IF we reach the end of the element string
                 if(i == each.length()-1){
                     //Add the element (word) to our return Array
                     returnList.add(each);
                 }
             }
        }
        return returnList.toArray(String[]::new);
    }


}
