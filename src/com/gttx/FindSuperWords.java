package com.gttx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 我们定义一个字符串的超集为：
 * 若字符串A包含字符串B中的所有字符，且字符串A中某一字符 a
 * 的数量不小于a在字符串B中的数量，那么A为B的“超集”。
 * 例如：
 * 若字符串A为 "abbccdd"，字符串B为 "abcdd"，那么A是B的“超 集”。 若A为"abbccd"，字符串B为"abcdd"，那么A不是B的“超集”。
 * 现给定字符串A、B，判断A是否是B的“超集”
 */
public class FindSuperWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串a:");
        String a = sc.nextLine();

        System.out.println("请输入字符串b:");
        String b = sc.nextLine();

        boolean isSuper = compareStrings(a, b);
        System.out.println(isSuper);
    }

    /**
     * 判断A是否是B的“超集”
     * @param A
     * @param B
     * @return
     */
    public static boolean compareStrings(String A, String B) {
        // write your code here
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] word1 = A.toCharArray();
        char[] word2 = B.toCharArray();
        for (char c : word1) {
            if (map1.containsKey(c)) {
                int val = map1.get(c);
                map1.put(c, ++val);
            } else {
                map1.put(c, 1);
            }
        }
        for (char c : word2) {
            if (map2.containsKey(c)) {
                int val = map2.get(c);
                map2.put(c, ++val);
            } else {
                map2.put(c, 1);
            }
        }
        boolean has = true;
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (map1.containsKey(entry.getKey())) {
                if (map1.get(entry.getKey()) < (entry.getValue())) {
                    has = false;
                    break;
                }
            } else {
                has = false;
                break;
            }
        }
        return has;
    }

}
