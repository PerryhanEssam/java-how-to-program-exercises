/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch14_18c;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch14_18c {
    public static void main(String[] args){
       String line = new String();
       Scanner input = new Scanner(System.in);
       line = input.nextLine();
            
       line = line.replaceAll("[,.:'()\"!]", "");
       line = line.toLowerCase();  
       String[] words = line.split(" ");
       System.out.println(line);
       
       countWordsOccurence(words, line);
    }
    
    public static void countWordsOccurence(String[] words, String line){
        ArrayList wordOccurence = new ArrayList<String>();
        ArrayList freq = new ArrayList<Integer>();
        
        for(int i = 0;i < words.length;i++){
            boolean flag = false;
            for(int j = 0;j < wordOccurence.size();j++){
                if(words[i].equals(wordOccurence.get(j))){
                    flag = true;
                }
            }
            
            if(flag){
                continue;
            }
            
            int counter = 0;
            for(int j = 0;j < words.length;j++){
                if(words[i].equals(words[j])){
                    counter++;
                }
            }
            
            wordOccurence.add(words[i]);
            freq.add(counter);
        }
        
        displayWordsOccurence(wordOccurence, freq);
    }
    
    public static void displayWordsOccurence(ArrayList<String> words, ArrayList<Integer> freq){
        System.out.printf("%-30s%-20s\n","Word", "Count");
        for(int i = 0;i < freq.size();i++){
            System.out.printf("%-30s%-20d\n", words.get(i), freq.get(i));
        }
    }
}






