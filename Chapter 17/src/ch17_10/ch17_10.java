/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17_10;

import java.io.IOException;
import java.util.Map;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ch17_10{
    public static void main(String[] args){
        try {
            Map<Object, Long> directory = Files.list(Paths.get("D:\\Programming Books"))
                    .filter(file -> !Files.isDirectory(file))
                    .map(file -> file.getFileName().toString())
                    .map(fileName -> fileName.substring(fileName.lastIndexOf('.') + 1))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            directory.keySet()
                    .forEach(e -> System.out.printf("%s  %d\n", (String) e, directory.get(e)));
        } 
        catch (IOException e) {
            System.out.println("Directory doesn't exist");
            System.exit(1);
        }
    }
}
