/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;
import javax.swing.JOptionPane;

/**
 *
 * @author HangYao
 */
public class BankAccountDemo {
    public static void main(String[] args) {
        // Use a menu to demonstrate the class
        String input;
        int op;
        
        input = JOptionPane.showInputDialog(null, 
                "The Balance of Savings Account:");
        double bal = Double.parseDouble(input);
        input = JOptionPane.showInputDialog(null, 
                "The Annual Interest Rate of Savings Account:");
        double rate = Double.parseDouble(input);
        SavingsAccount sa = new SavingsAccount(bal, rate);
        
        String menu = "Savings Account Menu:\n" +
                "1 - View the statement;\n" +
                "2 - Deposit;\n" +
                "3 - Withdraw;\n" +
                "4 - Monthly Process;\n" +
                "5 - Set Annual Interest Rate;\n" +
                "6 - Set Monthly Service Charges;\n" +
                "Other - Quit the program.";
        
        input = JOptionPane.showInputDialog(null, menu);
        while (input != null) {
            try {
                op = Integer.parseInt(input);
                switch (op) {
                    case 1:
                        // Print the statement
                        String strActive;
                        if (sa.isActive())
                            strActive = "Active";
                        else
                            strActive = "Inactive";
                        JOptionPane.showMessageDialog(null, 
                            "The Statement of Savings Account:\n\n" + 
                            "Status: " + strActive + "\n" +
                            sa + "\nNumber of Deposits: " + sa.getNumberDeposits() +
                            "\nNumber of Withdrawals: " + sa.getNumberWithdrawals() +
                            "\nMonthly Service Charges: $" + 
                            String.format("%.2f", sa.getMonthlyServiceCharges()));
                        input = JOptionPane.showInputDialog(null, menu);
                        break;
                    case 2:
                        // Deposit
                        input = JOptionPane.showInputDialog(null,
                                "The Amount of Deposit:");
                        double dep = Double.parseDouble(input);
                        sa.deposit(dep);
                        input = JOptionPane.showInputDialog(null, menu);
                        break;
                    case 3:
                        // Withdraw
                        input = JOptionPane.showInputDialog(null,
                                "The Amount of Withdraw:");
                        double wit = Double.parseDouble(input);
                        boolean flag = sa.withdraw(wit);
                        if (!flag)
                            JOptionPane.showMessageDialog(null,
                                "Withdraw failed.\n" +
                                "The account is inactive or doesn't have enough balance.");
                        input = JOptionPane.showInputDialog(null, menu);
                        break;
                    case 4:
                        // Monthly Process
                        sa.monthlyProcess();
                        if (sa.getBalance() < 0)
                            JOptionPane.showMessageDialog(null,
                                "The account doesn't have enough balance.");
                        input = JOptionPane.showInputDialog(null, menu);
                        break;
                    case 5:
                        // Set Annual Interest Rate 
                        input = JOptionPane.showInputDialog(null,
                                "The Annual Interest Rate:");
                        sa.setAnnualInterestRate(Double.parseDouble(input));
                        input = JOptionPane.showInputDialog(null, menu);
                        break;
                    case 6:
                        // Set Monthly Service Charges 
                        input = JOptionPane.showInputDialog(null,
                                "The Monthly Service Charges:");
                        sa.setMonthlyServiceCharges(Double.parseDouble(input));
                        input = JOptionPane.showInputDialog(null, menu);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "The program is quitting.");
                        System.exit(0);
                        break;
                }
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "The program is quitting.");
                System.exit(0);
            }
        }
    }
}
