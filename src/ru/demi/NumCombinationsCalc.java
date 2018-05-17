package ru.demi;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Написать программу, вычисляющую для любых натуральных m и r, таких что r ≤ m, значение функции
 * f(m,r)=m!/r!(m-r)!
 */
public class NumCombinationsCalc {

    private static HashMap<Integer, BigInteger> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mes = "Программа, вычисляющая для любых натуральных m и r, таких что r ≤ m, значение функции: f(m,r)=m!/r!(m-r)!";
        System.out.println(mes);

        System.out.println("Введите m:");
        int m = scanner.nextInt();
        System.out.println("Введите r:");
        int r = scanner.nextInt();

        System.out.println(String.format("Результат вычисления: %s", calc(m, r)));
    }

    public static BigInteger calc(int m, int r) {
        if (m <= 0 || r <= 0) {
            throw new IllegalArgumentException("Аргументы должны быть натуральными числами.");
        }

        if (r > m) {
            throw new IllegalArgumentException("r аргумент должен быть меньше или равен m.");
        }

        return calcFact(m).divide(calcFact(r).multiply(calcFact(m - r)));
    }

    private static BigInteger calcFact(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        BigInteger res = cache.get(n);
        if (res != null) {
            return res;
        }

        res = BigInteger.valueOf(n).multiply(calcFact(n - 1));
        cache.put(n, res);

        return res;
    }
}
