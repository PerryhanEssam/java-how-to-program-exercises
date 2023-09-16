/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch16_16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ch16_16 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        String line = new String();
        line = input.nextLine();
        
        line = removePunctuation(line);
        Map<String, Integer> wordCount = createMap(line);
        System.out.printf("The count of duplicate words in line is: %d\n", countDuplicates(wordCount));
        
    }
    
    public static String removePunctuation(String line){
        line = line.replaceAll("[.,'\"?/\\!]", "");
        return line;
    } 
    
    public static Map<String,Integer> createMap(String line){
        String[] tokens = line.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        
        for(int i = 0;i < tokens.length;i++){
            if(wordCount.containsKey(tokens[i])){
                int value = wordCount.get(tokens[i]);
                wordCount.put(tokens[i], value + 1);
            }
            else{
                wordCount.put(tokens[i], 1);
            }
        }
        return wordCount;
    }
    
    public static int countDuplicates(Map<String, Integer> wordCount){
        int counter = 0;
        Set<String> keys = wordCount.keySet();
        
        for(String word: keys){
            if(wordCount.get(word) > 1){
                counter++;
            }
        }
        return counter;
    }
    
}
