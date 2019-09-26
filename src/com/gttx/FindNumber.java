package com.gttx;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 某些整数能分解成若干个连续整数的和的形式，例如
 * 15 = 1 + 2+3+4+5
 * 15 = 4 + 5 + 6
 * 15 = 7 + 8
 * 某些整数不能分解为连续整数的和，例如:16
 * 输入: 一个整数N(N <= 10000)
 * 输出:整数N对应的所有分解组合，按照每个分解中的最小整数
 * 从小到大输出，每个分解占一行 ，每个数字之间有一个空格(每
 * 行最后保留一个空格);如果没有任何分解组合，则输出NONE。
 */
public class FindNumber {
    public static void main(String[] args) {
        String s = charScanner();
        if (isNumeric(s)) {
            int n = Integer.parseInt(s);
            if (n > 10000) {
                System.out.println("!Error 输入数值超过范围");
            } else {
                splitNumber(n);
            }
        } else {
            System.out.println("!Error 请输入数字");
        }
    }


    private static String charScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数N(N <= 10000)：");
        return sc.nextLine();
    }

    /**
     * 检测输入是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    /**
     * 数字对应的所有分解组合
     * @param n
     */
    private static void splitNumber(int n) {
        int startNumber;
        int endNumber;
        int flag = 0;
        for (startNumber = 1; startNumber < n; startNumber++) {
            for (endNumber = startNumber + 1; endNumber < n; endNumber++) {
                int sum = (startNumber + endNumber) * (endNumber - startNumber + 1) / 2;
                if (sum == n) {
                    flag = 1;
                    System.out.print(n + " = ");
                    for (int j = startNumber; j <= endNumber; j++) {
                        System.out.print(j);
                        if (j != endNumber) {
                            System.out.print(" + ");
                        }
                    }
                    System.out.println();
                }
            }
        }
        if (flag == 0) {
            System.out.println("NONE");
        }
    }
}
