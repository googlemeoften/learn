package cn.edu.learn.interview.pattern;

/**
 * @description:
 * @USER:hey
 * @Date:2016/3/25
 */
public class HeapSort {

    private int[] nums = new int[10];
    private int count = 0;

    public void insert(int num) {
        nums[count] = num;
        upStream(count++);
    }

    public int remove() {
        int tmp = nums[0];
        nums[0] = nums[--count];
        downStrean(0);
        return tmp;
    }

    public void upStream(int index) {

        int parent = (index - 1) >>> 1;
        int temp = nums[index];
        while (index > 0 && nums[parent] < temp) {
            nums[index] = nums[parent];
            index = parent;
            parent = (parent - 1) >>> 1;
        }
        nums[index] = temp;
    }

    public void downStrean(int index) {
        int maxChild = 0;
        int temp = nums[0];

        while (index < count >>> 1) {
            maxChild = maxChild(index);

            if (nums[maxChild] < temp) {
                break;
            } else {
                nums[index] = nums[maxChild];
                index = maxChild;
            }

        }
        nums[index] = temp;
    }

    private int maxChild(int index) {

        int leftChild = (index << 1) + 1;
        int rightChild = (index << 1) + 2;

        return nums[leftChild] > nums[rightChild] ? leftChild : rightChild;
    }
}
