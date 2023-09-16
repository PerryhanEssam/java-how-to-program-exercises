/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch15_4;

public class TransactionRecord {
    private int accountNumber;
    private double amount;
    
    public TransactionRecord(){
        this(0, 0.0);
    }
    
    public TransactionRecord(int accountNumber, double amount){
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public int getAccountNumber(){
        return this.accountNumber;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
}
