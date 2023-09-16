/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch17_11;

import java.util.Arrays;
import java.util.Comparator;

public class ch17_11 {
    public static void main(String[] args){
        Invoice[] invoice = {new Invoice("83", "Electric Sander", 7,57.98),
                             new Invoice("24", "Power saw", 18, 99.99),
                             new Invoice("7", "Sledge hammer", 11, 21.50),
                             new Invoice("77", "Hammer", 76, 11.99),
                             new Invoice("39", "Lawn mower", 3, 79.50),
                             new Invoice("68", "Screwdriver", 106, 6.99),
                             new Invoice("56", "Jig saw", 21, 11.00),
                             new Invoice("3", "Wrench", 34, 7.50)};
        
        
        sortByPartDescription(invoice);
        sortByPrice(invoice);
        sortByQuantityAfterMapping(invoice);
        sortByValueAfterMapping(invoice);       
        sortByValueAfterFilter(invoice);
        
        
    }
    
    public static void sortByPartDescription(Invoice[] invoice){
        Arrays.stream(invoice)
              .sorted(Comparator.comparing(Invoice::getPartDescription))
              .forEach(e -> System.out.printf("%s \n\n",e));
    }
    
    
    public static void sortByPrice(Invoice[] invoice){
        Arrays.stream(invoice)
              .sorted(Comparator.comparing(Invoice::getPricePerItem))
              .forEach(e -> System.out.printf("%s \n\n",e));
    }
    
    public static void sortByQuantityAfterMapping(Invoice[] invoice){
        Arrays.stream(invoice)
              .sorted(Comparator.comparing(Invoice::getQuantity))
              .map(e-> String.format("%s   %s", e.getPartDescription(), e.getQuantity()))
              .forEach(e -> System.out.printf("%s \n",e));
    }
    
    public static void sortByValueAfterMapping(Invoice[] invoice){
        Arrays.stream(invoice)
              .sorted(Comparator.comparing(Invoice::InvoiceValue))
              .map(e-> String.format("%s   %s", e.getPartDescription(), e.InvoiceValue()))
              .forEach(e -> System.out.printf("%s \n",e));
    }
    
    public static void sortByValueAfterFilter(Invoice[] invoice){
        Arrays.stream(invoice)
              .sorted(Comparator.comparing(Invoice::InvoiceValue))
              .filter(e -> e.InvoiceValue() >= 200 && e.InvoiceValue() <= 500)
              .map(e-> String.format("%s   %s", e.getPartDescription(), e.InvoiceValue()))
              .forEach(e -> System.out.printf("%s \n",e));
    }
}
