package com.austin.training.day6;

/**
 * @ClassName: reverseStr2
 * @author: zqz
 * @date: 2023/10/18 22:44
 */

public class reverseStr2 {

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public static void reverse(char[] s, int start, int end) {

        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


}
