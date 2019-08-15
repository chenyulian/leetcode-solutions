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
     * 加一
     */
    public int[] plusOne(int[] digits) {

        if(digits == null || digits.length == 0){
            return null;
        }

        /**
         * 如果最后一位不为9，则不会发生进位
         * 直接将最后一位数字+1，并返回
         */
        if(digits[digits.length-1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }

        /**
         * 从后往前遍历数组
         * 如果该位是9，则它的高位需要+1，当前位置为0
         * 循环到下一次，如果当前位不为9，则当前位+1，然后返回（在上一次循环中，当前位的低位已经置为0）
         * 否则，继续循环
         */
        for(int i = digits.length-1; i > 0; i --) {
            if(digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }else {
                digits[i] = 0;
            }
        }

        /**
         * 在上一步中，循环到i = 1时，如果此时digits[1]仍为9，跳出循环后没有返回，此时digits是[x,0,0,...,0]的形式。
         * 判断首位是否为9。
         * 如果首位为9，则返回一个新数组，长度是原数组长度+1,首位为1
         * 如果首位不为9，则首位+1，返回
         */
        if(digits[0] != 9) {
            digits[0] += 1;
            return digits;
        }else{
            int[] newDigits = new int[digits.length + 1];
            //java int数组默认值为0，因此只需要设置首位为1
            newDigits[0] = 1;
            return newDigits;
        }

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
                    test[i] = Integer.valueOf(temp[i].trim());
                }
                LeetArray arrays = new LeetArray();
                //int result = arrays.pivotIndex(test);
                int[] result = arrays.plusOne(test);
                //System.out.print("中心索引：" + result);
                for(int i = 0; i<=result.length -1; i ++) {
                    System.out.print(result[i]+", ");
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
