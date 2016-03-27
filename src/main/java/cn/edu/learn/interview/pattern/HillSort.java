package cn.edu.learn.interview.pattern;

/**
 * @description: 希尔排序
 * @USER:hey
 * @Date:2016/3/25
 */
public class HillSort {

    public static void sort(int[] nums) {
        if (nums == null)
            throw new IllegalArgumentException("the input is null");

        int j = 0;
        int length = nums.length;

        for (int val = length >> 1; val > 0; val >>= 1) {

            for (int i = val; i < length; i++) {

                int temp = nums[i];
                for (j = i; j >= val && temp < nums[j - val]; j -= val) {

                    nums[j] = nums[j - val];
                }
                nums[j] = temp;
            }
        }
    }

}
