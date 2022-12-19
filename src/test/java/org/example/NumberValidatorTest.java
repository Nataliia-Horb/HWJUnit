package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {
    private static List<String> correctValueslist;

    @BeforeAll
    public static void init() {
        correctValueslist = Arrays.asList(" 12345678912345", "12345678912345", "111111111     11111 ", "00000000000001");
    }

    @Test
    public void isValidAccountNumber() {
        for (String str : correctValueslist) {
            assertTrue(NumberValidator.isValidAccountNumber(str)); //проверка  на корректность с учетом чистки пробелов
        }
        assertFalse(NumberValidator.isValidAccountNumber(""));// проверка на  нулевую строку.
        assertFalse(NumberValidator.isValidAccountNumber(null)); // проверка на пустоту
        assertFalse(NumberValidator.isValidAccountNumber("1234512345678"));// проверка на символы менее 14
        assertFalse(NumberValidator.isValidAccountNumber("1234512345678000"));// проверка на символы более 14
        assertFalse(NumberValidator.isValidAccountNumber("+2345a1234sd56")); // проверка на надичие только цыфр
        assertFalse(NumberValidator.isValidAccountNumber("00000000000000"));// проверка на 14 нулей

    }
}