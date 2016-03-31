package cn.edu.learn.interview.pattern.test;

import cn.edu.learn.interview.pattern.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


/**
 * @description:
 * @USER:hey
 * @Date:2016/3/25
 */
public class InterviewTest {

    int[] nums = null;

    @Before
    public void init() {
        nums = new int[10];
        for (int i = 0; i < nums.length; i++)
            nums[i] = (int) (Math.random() * 100);
    }

    @Test
    public void testQuickSoet() {

        System.out.println("before sort :" + Arrays.toString(nums));

        QuickSort.sort(nums, 0, nums.length - 1);

        System.out.println("after sort :" + Arrays.toString(nums));
    }

    @Test
    public void testMergeSort() {
        System.out.println("before sort :" + Arrays.toString(nums));

        MergeSort.sort(nums);

        System.out.println("after sort :" + Arrays.toString(nums));
    }

    @Test
    public void testHillSort() {
        System.out.println("before sort :" + Arrays.toString(nums));

        HillSort.sort(nums);

        System.out.println("after sort :" + Arrays.toString(nums));
    }

    @Test
    public void testHeapSort() {
        HeapSort heap = new HeapSort();
        for (int i = 0; i < nums.length; i++) {
            int num = (int) (Math.random() * 100);
            System.out.print(num + " ");
            heap.insert(num);
        }
        System.out.println("");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(heap.remove() + " ");
        }
    }

    @Test
    public void testBinarySearch() {

        System.out.println("before sort :" + Arrays.toString(nums));

        HillSort.sort(nums);

        System.out.println("after sort :" + Arrays.toString(nums));

        // int searchNum = (int) (Math.random() * 100);
        int searchNum = nums[(int) (Math.random() * 10)];
        System.out.println(searchNum);
        int postion = BinarySearch.binarySearch2(nums, searchNum);
        System.out.println(postion);
    }
}
