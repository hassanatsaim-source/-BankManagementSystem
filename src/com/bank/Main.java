package com.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("=== Welcome to Java Bank Management System ===");

        // Account Setup with try-catch error recovery
        while (account == null) {
            try {
                System.out.print("Enter Account Number: ");
                String accNum = scanner.nextLine();

                System.out.print("Enter Account Holder Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Initial Deposit Amount (₹): ");
                double initialDeposit = scanner.nextDouble();
                scanner.nextLine(); // consume leftover newline

                account = new BankAccount(accNum, name, initialDeposit);
                System.out.println("Account created successfully!\n");

            } catch (InvalidAmountException e) {
                System.out.println("Setup Error: " + e.getMessage() + " Please try again.\n");
            } catch (InputMismatchException e) {
                System.out.println("Input Error: Please enter valid numeric values for the balance.\n");
                scanner.nextLine(); // clear invalid buffer token
            }
        }

        // Interactive Transaction Menu
        int choice = 0;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: ₹" + account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit (₹): ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        account.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw (₹): ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();
                        account.withdraw(withdrawAmount);
                        break;

                    case 4:
                        account.displayAccountDetails();
                        break;

                    case 5:
                        System.out.println("Thank you for using Java Bank. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select between 1 and 5.");
                }

            } catch (InvalidAmountException e) {
                System.out.println("Transaction Error: " + e.getMessage());
            } catch (InsufficientBalanceException e) {
                System.out.println("Transaction Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Input Error: Please enter valid numbers only.");
                scanner.nextLine(); // clear invalid token
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

        } while (choice != 5);

        scanner.close();
    }
}