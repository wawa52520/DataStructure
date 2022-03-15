package LeetCode;

/**
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * Related Topics
 * @author: yaojiabin
 * @date: 2022/3/4 9:47
 */
public class Day3Q1 {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 1; j < strs.length; j++) {
                char[] outerLoop = strs[i].toCharArray();
                char[] innerLoop = strs[j].toCharArray();
                for (int k = 0; k < outerLoop.length; k++) {
                    if (outerLoop[k] == innerLoop[k]) {
                        StringBuilder innerResult = new StringBuilder();
                        innerResult.append(outerLoop[k]);
                        if (innerResult.length() > result.length()) {
                            result = innerResult;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] begin = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(begin));
        System.out.println(2.5%4+2.5);
    }
}
