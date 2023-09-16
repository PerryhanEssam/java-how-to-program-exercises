/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17_12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ch17_12 {
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       String line = input.nextLine();
       duplicateRemoval(line);
    }
    
    public static void duplicateRemoval(String line){
        String[] words = line.split(" ");
        Arrays.stream(words)
              .map(String::toLowerCase)
              .collect(Collectors.toCollection(TreeSet::new))
              .forEach(System.out::println);
        
    }
}
