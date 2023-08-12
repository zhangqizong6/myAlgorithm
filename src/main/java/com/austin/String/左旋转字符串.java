package com.austin.String;

/**
 * @ClassName: 左旋转字符串
 * @author: zqz
 * @date: 2023/8/12 16:23
 */

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 为了让本题更有意义，提升一下本题难度：不能申请额外空间，只能在本串上操作。
 */

public class 左旋转字符串 {

    public String leftReverseStr(String str, int target) {

        //反转三次即可在原有的串上进行
        int length = str.length();
        StringBuilder sb = new StringBuilder(str);
        reverseString(sb, 0, target - 1);
        reverseString(sb, target, length - 1);

        return sb.reverse().toString();

    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }


}
