package cn.edu.learn.interview.pattern;

/**
 * @description: quick sort
 * @USER:hey
 * @Date:2016/3/25
 */
public class QuickSort {


    /**
     * QuickSort
     *
     * @param nums
     */
    public static void sort(int[] nums, int left, int right) {

        if (nums == null)
            throw new IllegalArgumentException("the array is null");
        if ((right - left) < 1)
            return;

        int part = partition(nums, left, right);

        sort(nums, left, part - 1);
        sort(nums, part + 1, right);

    }

    /**
     * find the signal
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] a, int left, int right) {

        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] < a[right]) {
                index++;
                if (index != i) {
                    swap(a, index, i);
                }
            }
        }

        if (index + 1 != right)
            swap(a, index + 1, right);
        return index + 1;
    }

    /**
     * swap the elements
     *
     * @param a
     * @param index1
     * @param index2
     */
    public static void swap(int[] a, int index1, int index2) {
        a[index1] = a[index1] ^ a[index2];
        a[index2] = a[index2] ^ a[index1];
        a[index1] = a[index1] ^ a[index2];
    }
}
