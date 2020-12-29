package com.company;

import java.util.Scanner;

public class BankAccount {
    private int balance = 0;
    private int previousTransaction = 0;
    private String  customerName;
    private String  customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public int getPreviousTransaction() {
        if (previousTransaction > 0) System.out.println("Deposited: " + previousTransaction);
        else if (previousTransaction < 0) System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        else System.out.println("No transaction occurred");
        return previousTransaction;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void deposit(int amount) {
        if (amount!=0) {
            this.balance+=amount;
            this.previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount != 0) {
            this.balance-=amount;
            this.previousTransaction =-amount;
        }
    }

    public void operation() {
        char option = '\0'; //empty char
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + this.getCustomerName());
        System.out.println("You ID is " + this.getCustomerId());
        System.out.println("\n");

        this.showMenu();
        do {
            option = Character.toLowerCase(scanner.next().charAt(0));
            switch (option) {
                default:
                    System.out.println("Error, not command has been recognized, choose another options");
                    System.out.println("(H for calling help menu)");

                    break;
                case 'a':
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Balance: " + this.getBalance());
                    System.out.println("(H for calling help menu)");
                    System.out.println("Done!");
                    System.out.println("-----------------------------------------------------");

                    break;
                case 'b':
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("(H for calling help menu)");
                    int deposit1 = scanner.nextInt();
                    this.deposit(deposit1);
                    System.out.println("Done!");
                    System.out.println("-----------------------------------------------------");

                    break;
                case 'c':
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Enter the amount to withdraw");
                    int deposit2 = scanner.nextInt();
                    this.deposit(deposit2);
                    System.out.println("Done!");
                    System.out.println("-----------------------------------------------------");

                    break;
                case 'd':
                    System.out.println("-----------------------------------------------------");
                   this.getPreviousTransaction();
                    System.out.println("(H for calling help menu)");
                    System.out.println("Done!");
                    System.out.println("-----------------------------------------------------");

                    break;
                case 'h':
                    showMenu();
                    break;
                case 'e':
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Thank you for using our service!");
                    System.out.println("-----------------------------------------------------");
                    break;
            }
        } while (option!='e');
    }

    public void showMenu() {
        System.out.println("===============================================================");
        System.out.println("Choose the option");
        System.out.println("===============================================================");
        System.out.println("A - Check Balance");
        System.out.println("B - Deposit");
        System.out.println("C - Withdraw");
        System.out.println("D - Show Previous transaction");
        System.out.println("H - Help menu");
        System.out.println("E - Exit");
    }
}
