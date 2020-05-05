package easy;

/**
 * LeetCode 747.Largest Number At Least Twice of Others
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int result = -1;
        int maxNum = 0;
        int secondMaxNum = 0;

        //数组的长度在[1,50]之间
        if(nums.length == 0 || nums.length > 50) {
            return -1;
        }
        //数组只有一个元素
        if(nums.length == 1) {
            return 0;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] > maxNum) {
                secondMaxNum = maxNum;
                maxNum = nums[i];
                result = i;
            }else{
                if(nums[i] > secondMaxNum) {
                    secondMaxNum = nums[i];
                }
            }
        }

        if(secondMaxNum * 2 > maxNum) {
            result = -1;
        }
        return result;
    }
}
