package LeetCode;

/**
 * @description: //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * // 示例 1:
 * //输入: num = 38
 * //输出: 2
 * //解释: 各位相加的过程为：
 * //38 --> 3 + 8 --> 11
 * //11 --> 1 + 1 --> 2
 * //由于 2 是一位数，所以返回 2。
 * //
 * // 示例 1:
 * //
 * //输入: num = 0
 * //输出: 0
 * //
 * // 提示：
 * //
 * // 0 <= num <= 2³¹ - 1
 * // 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
 * //
 * @author: yaojiabin
 * @date: 2022/3/3 10:31
 */
public class Day2Q1 {
    /**
     * @description: 各位相加
     * @author: yaojiabin
     * @date: 2022/3/3 11:05
     */
    public static int addDigits(int num) {
        //当传值小于10时，直接返回该数
        if (num < 10)
            return num;

        int firstNum = num;
        String stringNum = String.valueOf(firstNum);

        //将传值转为String后再转为char，循环char进行累加
        char[] charNum = stringNum.toCharArray();
        int result = 0;
        for (int i = 0; i < charNum.length; i++) {
            result += Integer.valueOf(String.valueOf(charNum[i]));
        }
        //递归传的值
        firstNum = result;
        //当结果<10时，直接返回结果，否则继续递归
        if (result < 10) {
            return result;
        }else{
            return addDigits(firstNum);
        }


    }

    public static void main(String[] args) {
        int num = 512111;
        int result = addDigits(num);
        System.out.println(result);
    }
}
