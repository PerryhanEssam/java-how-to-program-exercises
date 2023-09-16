/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17_14;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ch17_14 {
    
       public static void main(String[] args){
           int size = 5;
           int[] numbers = new int[size];
           
           Scanner input = new Scanner(System.in);
   
           for(int i = 0;i < size;i++){
               numbers[i] = input.nextInt();
           }
        
           System.out.println(
           IntStream.of(numbers)
                      .map(e -> e * e)
                      .reduce(0, (x, y) -> x + y));
       }
       
}
