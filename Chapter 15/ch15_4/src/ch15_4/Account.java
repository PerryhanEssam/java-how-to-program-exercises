/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch15_4;

public class Account {
    private int account;
    private String firstName;
    private String lastName;
    private double balance;
    
    public Account(){
        this(0, "", "", 0.0);
    }
    
    public Account(int account, String firstName, String lastName, double balance){
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    
    public void setAccount(int account){
        this.account = account;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setbalance(double balance){
        this.balance = balance;
    }
    
    public int getAccount(){
        return account;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public double getbalance(){
        return balance;
    }
    
    public void combine(TransactionRecord transaction){
        this.balance = this.balance + transaction.getAmount();
    }
}
