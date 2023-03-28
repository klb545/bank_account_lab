package org.example;

import java.time.LocalDate;

public class BankAccount {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String accountNumber;
    private double balance;
    private String accountType;
    private int overdraft;


//    constructor
    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, String accountType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = "";
        this.balance = 0;
        this.accountType = "";
        this.overdraft = -500;
    }

//    getters
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
    public String getAccountType(){
        return this.accountType;
    }
    public Integer getOverdraft(){
        return this.overdraft;
    }

//    setters
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }
    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }
    public void setDateOfBirth(LocalDate newDateOfBirth){
        this.dateOfBirth = newDateOfBirth;
    }
    public void setAccountNumber(String newAccountNumber){
        this.accountNumber = newAccountNumber;
    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
    public void setAccountType(String newAccountType){
        this.accountType = accountType;
    }
    public void setOverdraft(Integer newOverdraft){
        this.overdraft = newOverdraft;
    }


//    custom methods
    public void deposit(int amountForDeposit){
        this.balance += amountForDeposit;
    }
    public void withdraw(int amountToWithdraw){
        if(balance - amountToWithdraw >= this.overdraft){
            this.balance -= amountToWithdraw;
        }
    }
    public void payInterest(String firstName, String lastName, String accountType){
        if (accountType.equals("saver")){
            this.balance *= 1.005;
        } else if (accountType.equals("ISA")) {
            this.balance *= 1.04;
        }
    }

}
