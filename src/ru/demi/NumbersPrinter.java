package ru.demi;

/**
 * Написать программу, которая выводит числа от 1 до 100, но вместо чисел кратных 2 нужно выводить строку Two,
 * вместо чисел кратных 7 - строку Seven, вместо чисел кратных 2 и 7 - строку TwoSeven.
 */
public class NumbersPrinter {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String res;
            if (i % 2 == 0 && i % 7 == 0) {
                res = "TwoSeven";
            } else if (i % 2 == 0) {
                res = "Two";
            } else if (i % 7 == 0) {
                res = "Seven";
            } else {
                res = String.valueOf(i);
            }
            System.out.println(res);
        }
    }
}
