package com.test;

/**
 * @Author: fzy (zy.fu01@zuche.com)
 * @Date: 2017/3/17 15:35
 * @Description:
 * Word Maze 是一个网络小游戏，你需要找到以字母标注的食物，但要求以给定单词字母的顺序吃掉。如上图，假设给定单词if，你必须先吃掉i然后才能吃掉f。
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
    }


}