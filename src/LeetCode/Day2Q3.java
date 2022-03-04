package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * 示例 5:
 * <p>
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 提示：
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * Related Topics
 * 哈希表
 * 数学
 * 字符串
 * @author: yaojiabin
 * @date: 2022/3/3 16:39
 */
public class Day2Q3 {
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> specialMap = new HashMap<>();
        int result = 0;
        //常规
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        //特殊情况
        specialMap.put("IV", 4);
        specialMap.put("IX", 9);
        specialMap.put("XL", 40);
        specialMap.put("XC", 90);
        specialMap.put("CD", 400);
        specialMap.put("CM", 900);
        char[] chars = s.toCharArray();

        //单个值直接返回
        if (map.containsKey(s)) {
            return map.get(s);
        } else if (specialMap.containsKey(s)) {
            return specialMap.get(s);
        }

        /**
         * @description: 首先每两位进行判断，如果匹配到特殊数值，则进入累加，并使计数器i+1，没匹配到特殊数值则每一位进行累加
         * @author: yaojiabin
         * @date: 2022/3/4 9:19
         */
        for (int i = 0; i < chars.length; i++) {
            //判断最高位是否含有特殊情况
            if (i + 1 != chars.length && specialMap.containsKey(String.valueOf(chars[i]) + String.valueOf(chars[i + 1]))) {
                result += specialMap.get(String.valueOf(chars[i]) + String.valueOf(chars[i + 1]));
                i++;
            } else {
                result += map.get(String.valueOf(chars[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //1994
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
