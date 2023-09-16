/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17_13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ch17_13 {
    
     public static void main(String[] args){
        
        List<Character> list = generateRandom();
        
        sortAscending(list);
        System.out.println();
        sortDescending(list);
        System.out.println();
        sortDuplicateRemoved(list);
     }
     
     public static List<Character> generateRandom(){
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        List<Character> list = new ArrayList<>();
        
        for(int i = 0;i < 30;i++){
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            list.add(c);
        }
        
        return list;
     }
     
     public static void sortAscending(List<Character> list){
         list.stream()
             .sorted()
             .forEach(e -> System.out.printf("%c ", e));
     }
     
     public static void sortDescending(List<Character> list){
         list.stream()
             .sorted(Comparator.reverseOrder())
             .forEach(e -> System.out.printf("%c ", e));
     }
     
     public static void sortDuplicateRemoved(List<Character> list){
         list.stream()
             .sorted()
             .collect(Collectors.toCollection(TreeSet::new))
             .forEach(e -> System.out.printf("%c ", e));
     }
}
