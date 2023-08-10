package com.austin.HashTable;

/**
 * @ClassName: 赎金信
 * @author: zqz
 * @date: 2023/8/10 16:04
 */

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * #
 */
public class 赎金信 {
    //这道题的基本解决方法确实是用hash的 但是呢 这种数量量低的直接用数组也一样的
    public boolean canConstruct(String ransomNote, String magazine) {
        //长度不一致
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        //定义一个哈希的映射数组
        int[] record = new int[26];

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] += 1;
        }

        for (char c : magazine.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i : record) {
            if (i < 0){
                return false;
            }
        }
        return true;


    }
}
