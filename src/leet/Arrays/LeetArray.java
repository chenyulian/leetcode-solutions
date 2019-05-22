package leet.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        for(int i = 0; i < nums.length; i ++) {
            int sumLeft = 0;
            int sumRight = 0;
            for(int j = i-1; j>=0;j--) {
                //第一个数的左侧数之和记为0
                if(j < 0) {
                    sumLeft = 0;
                }else {
                    //遍历左侧数
                    sumLeft += nums[j];
                }
            }
            for(int k = i+1; k < nums.length; k ++) {
                //遍历右侧数
                if(k > nums.length){
                    //最后一个数的右侧数之和记为0
                    sumRight = 0;
                }else {
                    sumRight += nums[k];
                }
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
        //int test[] = {1,1,2,5,11,2,1,5,3,1,13,6};
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请输入数组：（如[1,2,11,4]）");
            String testStr = bufferedReader.readLine();
            if(testStr != null && testStr.length() > 0){

                String[] temp = testStr.substring(1,testStr.length()-1).split(",");
                int[] test = new int[temp.length];

                for (int i = 0; i < temp.length; i++) {
                    test[i] = Integer.valueOf(temp[i]);
                }
                LeetArray arrays = new LeetArray();
                int result = arrays.pivotIndex(test);
                System.out.print("中心索引：" + result);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
