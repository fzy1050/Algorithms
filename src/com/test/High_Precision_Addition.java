package com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fzy on 17-3-18.
 *
 * 在计算机中，由于处理器位宽限制，只能处理有限精度的十进制整数加减法，比如在32位宽处理器计算机中，
 参与运算的操作数和结果必须在-231~231-1之间。如果需要进行更大范围的十进制整数加法，需要使用特殊
 的方式实现，比如使用字符串保存操作数和结果，采取逐位运算的方式。如下：
 9876543210 + 1234567890 = ?
 让字符串 num1="9876543210"，字符串 num2="1234567890"，结果保存在字符串 result = "11111111100"。
 -9876543210 + (-1234567890) = ?
 让字符串 num1="-9876543210"，字符串 num2="-1234567890"，结果保存在字符串 result = "-11111111100"。
 要求编程实现上述高精度的十进制加法。
 要求实现函数：
 void add (const char *num1, const char *num2, char *result)
 【输入】num1：字符串形式操作数1，如果操作数为负，则num1[0]为符号位'-'
 num2：字符串形式操作数2，如果操作数为负，则num2[0]为符号位'-'
 【输出】result：保存加法计算结果字符串，如果结果为负，则result[0]为符号位。
 注：
 I、   当输入为正数时，'+'不会出现在输入字符串中；当输入为负数时，'-'会出现在输入字符串中，且一定在输入字符串最左边位置；
 II、  输入字符串所有位均代表有效数字，即不存在由'0'开始的输入字符串，比如"0012", "-0012"不会出现；
 III、       要求输出字符串所有位均为有效数字，结果为正或0时'+'不出现在输出字符串，结果为负时输出字符串最左边位置为'-'。
 *
 */
public class High_Precision_Addition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();

        High_Precision_Addition tmp = new High_Precision_Addition();

        tmp.getResult(num1, num2);
    }

    public High_Precision_Addition(){}

    private void getResult(String num1, String num2){
        //判断是否有0
        if(num2.equals("0")){
            System.out.println(num1);
            return;
        }

        if(num1.equals("0")){
            System.out.println(num2);
            return;
        }

        //判断两个数的符号
        int sign1 = getSign(num1.charAt(0));
        int sign2 = getSign(num2.charAt(0));

        //符号相同做加法
        if(sign1 == sign2){
            add(num1,num2,sign1);
            return;
        }

        //符号不同做减法
        sub(num1, num2, sign1, sign2);
    }

    private int getSign(char ch){
        if(ch == '-')
            return -1;

        return 1;
    }


    private void add(String num1, String num2, int sign){
        int length1 = num1.length();
        int length2 = num2.length();

        if(sign == -1){
            num1 = num1.substring(1,length1);
            num2 = num2.substring(1,length2);

            length1 -= 1;
            length2 -= 1;
        }

        StringBuilder n1 = new StringBuilder(num1).reverse();
        StringBuilder n2 = new StringBuilder(num2).reverse();
        int length = length1 > length2 ? length1 : length2;
        length += 1;

        int[] a1 = transferToIntegerArray(n1);
        int[] a2 = transferToIntegerArray(n2);
        int[] result = new int[length];

        int flag = 0;

        for(int i = 0; i < length; i++){
            result[i] += flag;

            if(i < length1)
                result[i] += a1[i];

            if(i < length2)
                result[i] += a2[i];

            if(result[i] >= 10){
                flag = 1;
                result[i] -= 10;
            }else{
                flag = 0;
            }
        }

        printResult(result,length,sign);

    }

    private int[] transferToIntegerArray(StringBuilder builder){
        int length = builder.length();
        int[] a = new int[length];
        for(int i = 0; i < length; i++){
            a[i] = builder.charAt(i) - '0';
        }

        return a;
    }

    private void sub(String num1, String num2, int sign1, int sign2){
        int length1 = num1.length();
        int length2 = num2.length();
        int sign = 0;

        if(sign1 == -1){
            num1 = num1.substring(1,length1);
            length1 -= 1;
        }

        if(sign2 == -1){
            num2 = num2.substring(1,length2);
            length2 -= 1;
        }

        int length = length1 > length2 ? length1 : length2;
        int[] result = new int[length];
        StringBuilder n1 = new StringBuilder(num1).reverse();
        StringBuilder n2 = new StringBuilder(num2).reverse();
        int[] a1 = transferToIntegerArray(n1);
        int[] a2 = transferToIntegerArray(n2);

        //标识哪个操作数大
        int index = compare(num1,num2,length1,length2);
        int flag = 0;
        if(index == 0){
            System.out.println("0");
            return;
        }else if((index == 1)){//第一个操作数比第二个大
            sign = sign1;
            for(int i = 0; i < length; i++){
                result[i] = a1[i] - flag;

                if(i < length2){
                    if(result[i] >= a2[i]){
                        result[i] -= a2[i];
                        flag = 0;
                    }
                    else{
                        flag = 1;
                        result[i] = 10 + result[i] - a2[i];
                    }
                }
            }
        }else if(index == 2){
            sign = sign2;
            for(int i = 0; i < length; i++){
                result[i] = a2[i] - flag;

                if(i < length1){
                    if(result[i] >= a1[i]){
                        result[i] -= a1[i];
                        flag = 0;
                    }
                    else{
                        flag = 1;
                        result[i] = 10 + result[i] - a1[i];
                    }
                }
            }
        }//计算结束

        //输出计算结果
        printResult(result, length, sign);

    }

    private int compare(String num1, String num2, int length1, int length2){

        if(length1 > length2)
            return 1;
        else if(length1 < length2)
            return 2;
        else{
            for(int i = 0; i < length1; i++){
                if(num1.charAt(i) > num2.charAt(i))
                    return 1;
                else if(num1.charAt(i) < num2.charAt(i))
                    return 2;
            }
        }

        return 0;
    }

    private void printResult(int[] result, int length, int sign){

        boolean flag = true;

        if(sign == -1)
            System.out.print("-");

        for(int i = length-1; i >= 0; i--){
            if((result[i] == 0) && flag)
                continue;
            else{
                System.out.print(result[i]);
                flag = false;
            }

        }
    }
}
