package easy;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if(res.containsKey(target - nums[i])) {
                return new int[] {res.get(target - nums[i]), nums[i]};
            }
            res.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution");

    }
}
