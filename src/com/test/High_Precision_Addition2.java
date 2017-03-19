package com.test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by fzy on 17-3-19.
 */
public class High_Precision_Addition2 {

    public High_Precision_Addition2(){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);

        System.out.println(n1.add(n2));

    }

}
