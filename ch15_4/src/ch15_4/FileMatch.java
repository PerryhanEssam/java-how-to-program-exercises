/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch15_4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class FileMatch {
    private static Scanner oldMast;
    private static Formatter newMast;
    private static Formatter log;
    private static Scanner transaction;
    
    public static void main(String[] args){
        writeToNewMast();
        writeToLog();
    }
    
    public static void writeToNewMast(){ 
        try{
            oldMast = new Scanner(Paths.get("oldmast.txt"));
            newMast = new Formatter("newmast.txt");
            
            while(oldMast.hasNext()){
                Account account = new Account(oldMast.nextInt(), oldMast.next(), oldMast.next(), oldMast.nextDouble());
                double amount = checkAccount(account);
                newMast.format("%-10d%-20s%-10s%-5.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getbalance() + amount);
            }
        }
        catch(SecurityException | IOException | NoSuchElementException | IllegalStateException e){
            System.out.println(e.getMessage());
        }
        finally{
            oldMast.close();
            newMast.close();
        }
    }
    
    public static double checkAccount(Account account){
        int accountNumber;
        double amount;
        
        try{
            transaction = new Scanner(Paths.get("trans.txt"));
            
            while(transaction.hasNext()){
                accountNumber = transaction.nextInt();
                amount = transaction.nextDouble();
                
                if(accountNumber == account.getAccount()){
                    return amount;
                }
            }
            
        }
        catch(SecurityException | IOException | IllegalStateException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        finally{
            transaction.close();
        }
        return 0.0;
    }
    
    public static void writeToLog(){
        try{
            transaction = new Scanner(Paths.get("trans.txt"));
            log = new Formatter("log.txt");
            
            while(transaction.hasNext()){
               
                TransactionRecord trans = new TransactionRecord(transaction.nextInt(), transaction.nextDouble());
                if(!checkTransaction(trans)){
                    log.format("%s %d%n", "Unmatched record for account number", trans.getAccountNumber());
                }
            }
        }
        catch(SecurityException | IOException | NoSuchElementException | IllegalStateException e){
            System.out.println(e.getMessage());
        } 
        finally{
            transaction.close();
            log.close();
        }
    }
    
    public static boolean checkTransaction(TransactionRecord trans){
        try{
            oldMast = new Scanner(Paths.get("oldmast.txt"));
            
            while(oldMast.hasNext()){
                int account = oldMast.nextInt();
                oldMast.next();
                oldMast.next();
                oldMast.nextDouble();
                
                if(account == trans.getAccountNumber()){
                    return true;
                }
            }
        }
        catch(SecurityException | IOException | IllegalStateException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        finally{
            oldMast.close();
        }
        return false;
    }
}
