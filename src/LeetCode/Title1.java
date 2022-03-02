package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Title1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length ; i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) + nums[i+1] == target) {
                result[0] = i;
                result[1] = i+1;
                return result;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] test = new int[]{2,7,11,15};
        int[] sum = twoSum(test, 9);
        System.out.println(sum);
    }
}
