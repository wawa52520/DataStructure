package LeetCode;

import java.util.HashMap;
import java.util.Map;
/**
 * @description: 两数之和
 * @author: yaojiabin
 * @date: 2022/3/3 10:29
 */
public class Title1 {
    public static int[] twoSum(int[] nums, int target) {
        //返回的结果集
        int[] result = new int[2];
        //将传来的数据存入map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length ; i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]) && (map.get(target - nums[i])) != i ) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] test = new int[]{2,7,11,15};
        int[] sum = twoSum(test, 9);
        for (int i : sum) {
            System.out.println(i);
        }
    }
}
