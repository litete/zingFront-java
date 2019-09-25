package com.gttx;

import java.util.Scanner;

/**
 * 功能是求出字符 s 与字符串t的第二公共单词(这里，假设两个
 * 字符串均由英字母和空格字符组成);若找到这样的公共单词，
 * 函数返回该单词，否则，函数返回NULL，如果有多个满足要
 * 求，则返回第一个单词。
 * 例如:若 s=“This is C programming text”，t=“This is a text for C
 * programming”，则函数返回“this”。
 */
public class FindWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串s:");
        String s = sc.nextLine();

        System.out.println("请输入字符串t:");
        String t = sc.nextLine();

        String words = findWords(s, t);
        System.out.println("第二公共单词： " + words);
    }

    private static String findWords(String s, String t) {
        String returnWords;
        String[] sArr = s.split(" ");
        String[] tArr = t.split(" ");
        for (String sWords : sArr) {
            for (String tWords : tArr) {
                if (sWords.equals(tWords)) {
                    returnWords = tWords;
                    return returnWords;
                }
            }
        }
        return null;
    }
}
