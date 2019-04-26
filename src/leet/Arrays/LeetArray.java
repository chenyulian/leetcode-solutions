package leet.Arrays;

public class LeetArray {

    public LeetArray(){
        //
    }

    /**
     * 查找数组的中心索引
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        if(nums.length > 10000 || nums.length <= 0) {
            System.out.println("数组的长度范围在[0, 10000]之间！");
        }

        if(nums.length <= 2) {
            return -1;
        }

        int result = -1;
        for(int i = 1; i < nums.length-1; i ++) {
            int sumLeft = 0;
            int sumRight = 0;
            for(int j = i-1; j>=0;j--) {
                //遍历左侧数
                sumLeft += nums[j];
            }
            for(int k = i+1; k < nums.length; k ++) {
                //遍历右侧数
                sumRight += nums[k];
            }
            if(sumLeft == sumRight) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int test[] = {1,1,2,5,11,2,1,5,3,1,13,6};
        LeetArray arrays = new LeetArray();
        int result = arrays.pivotIndex(test);
        System.out.print("中心索引：" + result);
    }

}
