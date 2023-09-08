/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch14_18b;

import java.util.Scanner;

public class Ch14_18b {
    
    public static void main(String[] args){
       String line = new String();
       Scanner input = new Scanner(System.in);
       line = input.nextLine();
       
       line = line.replaceAll("[,.:'()\"!]", "");
       
       String[] words = line.split(" ");
       
       countWordLength(words); 
    }
    
     public static void countWordLength(String[] words){
         int[] freq = new int[50];
         for(int i = 0;i < words.length;i++){
            freq[words[i].length()]++;
         }
         
         displayWordLength(freq);
     }
     
     public static void displayWordLength(int[] freq){
        System.out.printf("%-30s%-20s\n","Word Length", "Count");
        for(int i = 1;i < freq.length;i++){
            System.out.printf("%-30d%-20d\n", i, freq[i]);
        }
     }
}
