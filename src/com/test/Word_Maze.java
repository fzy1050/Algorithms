package com.test;

import java.util.Scanner;

/**
 * @Author: fzy (zy.fu01@zuche.com)
 * @Date: 2017/3/17 15:35
 * @Description:
 *
Word Maze 是一个网络小游戏，你需要找到以字母标注的食物，但要求以给定单词字母的顺序吃掉。如上图，假设给定单词if，你必须先吃掉i然后才能吃掉f。
但现在你的任务可没有这么简单，你现在处于一个mí宫Maze（n×m的矩阵）当中，里面到处都是以字母标注的食物，但你只能吃掉能连成给定单词W的食物。
如下图，指定W为“SOLO”，则在地图中红色标注了单词“SOLO”。
注意区分英文字母大小写,你只能上下左右行走。
运行时间限制:  无限制
内存限制:  无限制
输入:
输入第一行包含两个整数n、m(0<n, m<21)分别表示n行m列的矩阵，第二行是长度不超过100的单词W，从第3行到底n+3行是只包含大小写英文字母的长度为m的字符串。
输出:
如果能在地图中连成给定的单词，则输出“YES”，否则输出“NO”。注意：每个字母只能用一次。
样例输入:
    5 5
    SOLO
    CPUCY
    EKLQH
    CRSOL
    EKLQO
    PGRBC
样例输出:yes
 */

public class Word_Maze {

    private Word_Maze(){}

    public static void main(String[] args) {

        Word_Maze tmp = new Word_Maze();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String ans = scanner.next();
        String[] str = new String[n];

        for(int i = 0; i < n; i++){
            str[i] = scanner.next();
        }

        tmp.findWord(str, n, m, ans);

    }

    private void findWord(String[]str, int n, int m, String ans){

        char[][] matrix = new char[n][m];
        int ans_index = 0;
        int ans_length = ans.length();
        int flag = -1;

        for(int i =0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = str[i].charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                int a = i;
                int b = j;
                while(ans_index < ans_length){
                    if(ans_index == ans_length - 1){
                        flag = towards(matrix, a , b , ans.charAt(ans_index), '0');
                    }else{
                        flag = towards(matrix, a , b , ans.charAt(ans_index), ans.charAt(ans_index + 1));
                    }

                    switch(flag){
                        case 0: ans_index = ans_length;break;
                        case 1: ans_index++; a--; break;
                        case 2: ans_index++; a++; break;
                        case 3: ans_index++; b--; break;
                        case 4: ans_index++; b++; break;
                        case 5:
                            System.out.println("yes");return;
                    }
                }

                ans_index = 0;
            }
        }

    }

    private int towards(char[][]matrix, int i , int j, char ans, char next){

        int row = matrix.length;
        int col = matrix[0].length;

        if(matrix[i][j] == ans){
            //left
            if((i - 1 > 0) && (matrix[i-1][j] == next)){
                return 1;
            }else if((i + 1 < row) && (matrix[i+1][j] == next)){//right
                return 2;
            }else if((j - 1 > 0) && (matrix[i][j-1] == next)){//up
                return 3;
            }else if((j + 1 < col) && (matrix[i][j+1] == next)){//down
                return 4;
            }

            return 5;
        }

        return 0;
    }


}
