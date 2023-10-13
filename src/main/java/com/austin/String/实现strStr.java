package com.austin.String;

/**
 * @ClassName: 实现strStr
 * @author: zqz
 * @date: 2023/9/11 18:27
 */

public class 实现strStr {

    private static void getNext(int[] next,String s){
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String needle = "aabaaf";
        int[] next = new int[needle.length()];
        getNext(next, needle);
        System.out.println(next);
    }
}
