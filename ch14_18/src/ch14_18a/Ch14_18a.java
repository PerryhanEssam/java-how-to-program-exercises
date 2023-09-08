/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch14_18a;

import java.util.Arrays;
import java.util.Scanner;

public class Ch14_18a {
    public static void main(String[] args){
       String line = new String();
       Scanner input = new Scanner(System.in);
       line = input.nextLine();
       countLetters(line);
    }
    
    public static void countLetters(String line){
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        line = line.toLowerCase();
        
        for(int i = 0;i < line.length();i++){
            if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z'){
                freq[line.charAt(i) - 'a']++;
            }
        }
        displayLetterCount(freq);
    }
    
    public static void displayLetterCount(int[] freq){
        System.out.printf("%-30s%-20s\n","Letter", "Frequency");
        for(int i = 0;i < freq.length;i++){
            System.out.printf("%-30c%-20d\n", (char)(i + 97), freq[i]);
        }
    }
    
}
