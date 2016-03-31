package cn.edu.learn.interview.pattern;

/**
 * @description: 二分查找
 * @author: hey
 * @date 2016/3/31
 * @version: 1.0
 */
public class BinarySearch {

    public static int search(int[] nums, Integer searchNum) {

        if (nums == null)
            throw new IllegalArgumentException("the search number is wrong");

        int postion = binarySearch(nums, searchNum, 0, nums.length - 1);
        return postion;
    }

    /**
     * 递归进行二分查找
     *
     * @param nums
     * @param searchNum
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(int[] nums, int searchNum, int left, int right) {


        if (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == searchNum)
                return mid;
            else if (nums[mid] > searchNum)
                return binarySearch(nums, searchNum, left, mid - 1);
            else
                return binarySearch(nums, searchNum, mid + 1, right);
        }
        return -1;
    }

    /**
     * while循环实现二分查找
     * @param nums
     * @param searchNum
     * @return
     */
    public static int binarySearch2(int[] nums, int searchNum) {
        int lfet = 0;
        int right = nums.length;

        while (lfet < right) {
            int mid = (lfet + right) >> 1;
            if (nums[mid] == searchNum)
                return mid;
            if (nums[mid] > searchNum)
                right = mid - 1;
            else
                lfet = mid + 1;
        }
        return -1;
    }

}
