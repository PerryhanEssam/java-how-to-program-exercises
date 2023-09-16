/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ch15_4;

import java.util.Formatter;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.util.Scanner;
import ch15_4.Account;
import java.util.NoSuchElementException;


public class CreateData {
    
    public static Formatter oldMast;
    public static Formatter transaction;
    
    public static void main(String[] args) {
        createMastFile();
        addAccountRecord();
        closeMastFile();
    }
    
    public static void createMastFile(){
        try{
            oldMast = new Formatter("oldmast.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("Can't open file");
        }
        catch(SecurityException e){
            System.out.println("Permission denied");
        }
    }
    
    public static Account setAccountInfo(){
        Scanner input = new Scanner(System.in);
        int acc = input.nextInt();
        if(acc == -1){
            return null;
        }
        Account account = new Account(acc, input.next(), input.next(), input.nextDouble());
        return account;
    }
    
    public static void addAccountRecord(){
        
        Account account = setAccountInfo();
        
        while(account != null){
            try{
                oldMast.format("%-10d%-20s%-10s%-5.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getbalance());
                account = setAccountInfo();
            }
            catch(FormatterClosedException e){
                System.out.println("File is closed");
            }
            catch(NoSuchElementException e){
                System.out.println("Error in data being entered");
            }
        }
    }
    
    public static void closeMastFile(){
        if(oldMast != null){
            oldMast.close();
        }
    }
    
    public static void createTransactionFile(){
        try{
            transaction = new Formatter("trans.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("Can't open file");
        }
        catch(SecurityException e){
            System.out.println("Permission denied");
        }
    }
    
    public static TransactionRecord setTransactionInfo(){
        Scanner input = new Scanner(System.in);
        int accountNumber = input.nextInt();
        if(accountNumber == -1){
            return null;
        }
        TransactionRecord trans = new TransactionRecord(accountNumber, input.nextDouble());
        return trans;
    }
    
    public static void addTransactionRecord(){
        
        TransactionRecord trans = setTransactionInfo();
        while(trans != null){
            try{
                transaction.format("%-5d%-5.2f%n", trans.getAccountNumber(), trans.getAmount()); 
                trans = setTransactionInfo();
            }
            catch(FormatterClosedException e){
                System.out.println("File is closed");
            }
            catch(NoSuchElementException e){
                System.out.println("Error in data being entered");
            }
        }
    }
    
    public static void closeTransactionFile(){
        if(transaction != null){
            transaction.close();
        }
    }
}
