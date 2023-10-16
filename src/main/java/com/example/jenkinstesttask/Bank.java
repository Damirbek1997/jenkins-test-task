package com.example.jenkinstesttask;

public class Bank {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public double withdrawal(double amount) {
        if (balance < amount) {
            amount = balance;
        }

        balance -= amount;
        return amount;
    }

    public double deposit(double amount) {
        balance += amount;
        return amount;
    }
}
