package com.austin.String;

/**
 * @ClassName: 替换空格
 * @author: zqz
 * @date: 2023/8/12 15:15
 */

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1： 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * #
 */
public class 替换空格 {

    /**
     * 这个是最常见的 一般就是直接for就行了
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param str
     * @return
     */
    public String replaceSpace(String str) {

        if (str == null) {
            return null;
        }
        //选用单线程
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }


}
