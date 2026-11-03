package com.bank;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (initialBalance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        balance += amount;
        System.out.println("Successfully deposited ₹" + amount + ". Updated Balance: ₹" + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal failed! Insufficient balance. Available balance: ₹" + balance);
        }
        balance -= amount;
        System.out.println("Successfully withdrew ₹" + amount + ". Updated Balance: ₹" + balance);
    }

    public void displayAccountDetails() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + accountHolderName);
        System.out.println("Current Balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }
}