/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author HangYao
 */
public abstract class BankAccount {
    private double balance;                  // Balance
    private int numberDeposits = 0;              // Number of Deposits
    private int numberWithdrawals = 0;           // Number of withdrawals
    private double annualInterestRate;       // Annual interest rate
    private double monthlyServiceCharges = 0;    // Monthly service charges
    
    /**
     * The Constructor sets the balance and annual interest rate of the bank account.
     * @param b The balance.
     * @param rate The annual interest rate.
     */
    public BankAccount(double b, double rate) {
        balance = b;
        annualInterestRate = rate;
    }
    
    /**
     * The toString method returns a String containing the bank account data.
     * @return A reference to a String.
     */
    public String toString() {
        String str;
        str = "Balance: $" + String.format("%.2f", balance) + 
              "\nAnnual Insterest Rate: " + 
              String.format("%.2f", (annualInterestRate * 100)) +
              "%";
        return str;
    }
    
    /**
     * The deposit method add a deposit to the account balance.
     * @param d The amount of the deposit.
     */
    public void deposit(double d) {
        balance += d;
        numberDeposits ++;
    }
    
    /**
     * The withdraw method subtract a withdrawal from the account balance.
     * @param w The amount of the withdrawal.
     * @return true if withdraw processed; false if withdraw failed.
     */
    public boolean withdraw(double w) {
        if (w <= balance) {
            balance -= w;
            numberWithdrawals ++;
            return true;
        }
        else
            return false;
    }
    
    /**
     * The calcInterest method updates the balance by adding a monthly interest.
     */
    public void calcInterest() {
        double monthlyInterest = balance * annualInterestRate / 12;
        balance += monthlyInterest;
    }
    
    /**
     * The monthlyProcess method updates the account fields.
     */
    public void monthlyProcess() {
        balance -= monthlyServiceCharges;
        calcInterest();
        numberDeposits = 0;
        numberWithdrawals = 0;
        monthlyServiceCharges = 0;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public int getNumberDeposits() {
        return numberDeposits;
    }
    
    public int getNumberWithdrawals() {
        return numberWithdrawals;
    }
    
    public double getMonthlyServiceCharges() {
        return monthlyServiceCharges;
    }
    
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }
    
    public void setMonthlyServiceCharges(double m) {
        monthlyServiceCharges = m;
    }
}
