/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17_9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ch17_9 {
    
    public static void main(String[] args) throws IOException{
       Pattern pattern = Pattern.compile("");
        
       try{
           Map<String, Long> charCount = createMap(pattern);
           displayCharCount(charCount);
       }
       catch(IOException e){
           System.out.println("File doesn't exist");
           System.exit(1);
       }
                       
    }
      
    public static Map<String, Long> createMap(Pattern pattern) throws IOException{
        Map<String, Long> charCount = Files.lines(Paths.get("C:\\Users\\w\\Documents\\NetBeansProjects\\ch15_4\\oldMast.txt"))
                                                           .map(e -> e.replaceAll("[.(),?!\"']",""))
                                                           .flatMap(e -> pattern.splitAsStream(e))
                                                           .collect(Collectors.groupingBy(String::toLowerCase,
                                                                 TreeMap::new,Collectors.counting()));
        
        return charCount;
    }
    
    public static void displayCharCount(Map<String, Long> charCount){
        charCount.keySet()
                 .stream()
                .forEach(character -> System.out.printf("%s   %d\n", character, charCount.get(character)));
    }
    
}
