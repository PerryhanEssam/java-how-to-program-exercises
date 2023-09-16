/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch16_20;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ch16_20 {
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       String line = new String();
       line = input.nextLine();
        
       line = removePunctuation(line);
       Set<String> sortedWords = createTreeSet(line);
       displaySortedWords(sortedWords);
       
    } 
      
    public static String removePunctuation(String line){
       line = line.replaceAll("[.,'\"?/\\!]", "");
       return line;
    } 
    
    public static Set<String> createTreeSet(String line){
        String[] tokens = line.split(" ");
        Set<String> words = new TreeSet<>();
        
        for(int i = 0;i < tokens.length;i++){
            words.add(tokens[i]);
        }
        return words;
    }
    
    public static void displaySortedWords(Set<String> words){
        for(String word: words){
            System.out.printf("%s ",word);
        }    
    }
}
