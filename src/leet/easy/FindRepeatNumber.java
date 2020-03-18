package easy;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i; j < nums.length - 1; j++) {
                if(nums[j + 1] == nums[i]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindRepeatNumber solution = new FindRepeatNumber();
        int[] test = {3, 1, 2, 3};
        System.out.println(solution.findRepeatNumber(test));
    }
}
