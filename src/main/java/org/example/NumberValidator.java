package org.example;


public class NumberValidator {

//        1. Написать метод проверки номера банковского счета public boolean isValidAccountNumber(String accountNumber)
//        и тесты проверки корректной работы метода
//        БС может содержать только 14 цифр
//        Все 14 цифр не могут быть нулями
//        Номер счета не может быть нулевым или пустым.
//        Задачу выполнить способом test-driven development, TDD (сначала написать тесты на метод, после чего напиcать сам метод).

    public static boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber == null) return false;

       accountNumber= accountNumber.replaceAll("\\s+", "");
        if (accountNumber.length() == 14) {
            accountNumber = accountNumber.chars().filter(Character::isDigit).collect(StringBuilder::new,
                    StringBuilder::appendCodePoint, StringBuilder::append).toString();
            long checkCount = accountNumber.chars().filter(e -> e == '0').boxed().count();
            return (accountNumber.length() == 14 && checkCount < 14);
        } else {
            return false;
        }
    }
}

