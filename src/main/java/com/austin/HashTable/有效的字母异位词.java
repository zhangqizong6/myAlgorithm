package com.austin.HashTable;

/**
 * @ClassName: 有效的字母异位词
 * @author: zqz
 * @date: 2023/8/8 09:47
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * <p>
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 * <p>
 * 说明: 你可以假设字符串只包含小写字母
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * #
 */
public class 有效的字母异位词 {

    public static boolean checkSameStr(String s, String t) {

        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count : record) {
            if (count != 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        boolean b = checkSameStr("qwer", "rdeq");
        boolean b1 = checkSameStr("qwer", "rewq");
        System.out.println(b);
        System.out.println(b1);
    }

}
