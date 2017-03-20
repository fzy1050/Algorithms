package com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fzy on 17-3-18.
 *
 * 10个学生考完期末考试评卷完成后，A老师需要划出及格线，要求如下：
 (1) 及格线是10的倍数；
 (2) 保证至少有60%的学生及格；
 (3) 如果所有的学生都高于60分，则及格线为60分
 思路：
 对分数排序，分数线是比第五个数小的整数。
 */
public class Pass_Line {

    public Pass_Line(){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Pass_Line tmp = new Pass_Line();
        tmp.getPassLine(str);
    }

    private void getPassLine(String str){
        String[] arr = str.split(" ");
        int size = arr.length;
        int[] scores = new int[size];

        for(int i = 0; i < size; i++){
            scores[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(scores);

        int pass_line = 60;
        if(scores[0] < 60)
            pass_line = scores[4] - scores[4] % 10;

        System.out.println(pass_line);
    }
}
