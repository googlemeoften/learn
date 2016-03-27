package cn.edu.learn.interview.pattern;

/**
 * @description: merge sort
 * @USER:hey
 * @Date:2016/3/25
 */
public class MergeSort {

    public static void sort(int[] nums) {
        if (nums == null)
            throw new IllegalArgumentException("the input is wrong");

        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        int mid = (left + right) >>> 2;

        if (left < right) {
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, left);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= left) {
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];

        }

        while (i < mid) {
            temp[k++] = nums[i++];
        }

        while (j < left) {
            temp[k++] = nums[j++];
        }

        for (int k2 = 0; k2 < temp.length; k++)
            nums[k2 + left] = temp[k2];
    }
}
