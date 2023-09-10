package com.austin.回溯算法;

/**
 * @ClassName: 电话号码的字母组合
 * @author: zqz
 * @date: 2023/9/10 17:33
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class 电话号码的字母组合 {

    /**
     * 回溯法来解决n个for循环的问题
     */
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        //判空操作
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始化所以的字符 由于电话的特殊 增加两个无效的字符串
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        //迭代处理
        this.backTracking(digits, numString, 0);
        return list;
    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();
    private void backTracking(String digits, String[] numString, int num) {

        //终止条件
        if (num == digits.length()){
            list.add(temp.toString());
            return;
        }

        //取当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            //将当前元素加入临时字段中
            temp.append(str.charAt(i));
            //开始递归
            backTracking(digits,numString,num+1);
            //如果递归完之后 回到这一层后剔除末尾元素然后再走下去
            temp.deleteCharAt(temp.length() -1 );
        }

    }
    /**
     * 这样剔除递归下去 就可以得到无论是二个三个数字都可以得到最后的答案
     */


}
