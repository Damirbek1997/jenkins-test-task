package com.example.jenkinstesttask;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BankTest {
    @Test
    public void withdrawal() {
        Bank bank = new Bank(10);
        double amount = bank.withdrawal(5);
        assertEquals(5.0, amount);
    }
}
