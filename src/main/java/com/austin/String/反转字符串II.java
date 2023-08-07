package com.austin.String;

/**
 * @ClassName: 反转字符串II
 * @author: zqz
 * @date: 2023/8/7 17:36
 */

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * <p>
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * <p>
 * #
 */
public class 反转字符串II {

    public static String reverseStr(String s, Integer k) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if (i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
                //跳过下面的
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(chars, i, chars.length - 1);
        }
        return new String(chars);
    }

    // 定义翻转函数
    public static void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }


    public static void main(String[] args) {
        String str = "bacdfeg";
        String s = reverseStr(str, 2);
        System.out.println(s);
    }

}
