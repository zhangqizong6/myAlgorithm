package com.austin.training.day6;

/**
 * @ClassName: reverseString
 * @author: zqz
 * @date: 2023/10/18 22:27
 */

/**
 * 反转字符串
 */
public class reverseString {

    public static void reverse(char[] s) {

        int start = 0;
        int end = s.length - 1;

        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverse(s);
        System.out.println(s);
    }

}
