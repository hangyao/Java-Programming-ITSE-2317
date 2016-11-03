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
public class SavingsAccount extends BankAccount {
    private boolean active;
    
    /**
     * The Constructor sets the balance and annual interest rate of the bank account.
     * @param b The balance.
     * @param rate The annual interest rate.
     */
    public SavingsAccount(double b, double rate) {
        super(b, rate);
        if (b < 25.) 
            active = false;
        else
            active = true;
    }
    
    /**
     * The withdraw method subtract a withdrawal from the account balance.
     * @param w The amount of the withdrawal.
     * @return true if withdraw processed; false if withdraw failed.
     */
    public boolean withdraw(double w) {
        if (active && (w <= super.getBalance())) {
            super.withdraw(w);
            if (super.getBalance() < 25.)
                active = false;
            return true;
        }
        else
            return false;        
    }
    
    /**
     * The deposit method add a deposit to the account balance.
     * @param d The amount of the deposit.
     */
    public void deposit(double d) {
        super.deposit(d);
        if (!active && (super.getBalance() >= 25.))
            active = true;
    }
    
    /**
     * The monthlyProcess method updates the account fields.
     */
    public void monthlyProcess() {
        int w = super.getNumberWithdrawals();
        if (w > 4){
            super.setMonthlyServiceCharges(super.getMonthlyServiceCharges() + (w - 4) * 1.);
        }
        super.monthlyProcess();
        if (super.getBalance() < 25.)
            active = false;
        else
            active = true;
    }
    
    /**
     * The isActive method checks if the account is active.
     * @return 
     */
    public boolean isActive() {
        return active;
    }
}
