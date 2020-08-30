package com.xiaoling.sort;

import java.util.*;

/**
 * @author xiaoling
 */
public class Sorts {
    public int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        // selectSort
        // return selectSort(nums);

        // insertSort
        // return insertSort(nums);

        // bubbleSort
        // return bubbleSort(nums);
        // return bubbleSortOptimize(nums);

        // shellSort
        // return shellSort(nums);
        // return shellSortOptimize(nums);

        // mergeSort
        // return mergeSort(nums, 0, nums.length - 1);
        // return mergeSort1(nums);

        // quickSort
        // return quickSort(nums, 0, nums.length - 1);

        // countingSort
        // return countingSort(nums);

        // bucketSort
        // return bucketSort(nums);

        // radioSort
        // return radioSort(nums);

        // headSort
        return heapSort(nums);
    }

    private int[] selectSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }

        return nums;
    }

    private int[] insertSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int k = i;
            int current = nums[i];
            while (k > 0 && current < nums[k - 1]) {
                k--;
            }

            for (int j = i; j > k; j--) {
                nums[j] = nums[j - 1];
            }
            nums[k] = current;
        }
        return nums;
    }

    private int[] bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }

    private int[] bubbleSortOptimize(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return nums;
    }

    private int[] shellSort(int[] nums) {
        int length = nums.length;
        int step = length / 2;
        while (step >= 1) {
            for (int i = step; i < length; i++) {
                int temp = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = temp;
            }

            step /= 2;
        }
        return nums;
    }

    private int[] shellSortOptimize(int[] nums) {
        int length = nums.length;
        int step = 1;
        // 优化1：调整递增序列，或者可以把3改成5
        while (step < length / 3) {
            step = step * 3 + 1;
        }

        int exchanges = 0;
        // 优化2：预处理数组，把大数尽量都往右边移动
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                exchanges++;
            }
        }

        if (exchanges == 0) {
            return nums;
        }

        // 执行希尔排序
        while (step >= 1) {
            for (int i = step; i < length; i++) {
                int temp = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = temp;
            }

            step /= 3;
        }
        return nums;
    }

    private int[] mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            nums = mergeSort(nums, left, middle);
            nums = mergeSort(nums, middle + 1, right);
            merge(nums, left, middle, right);
        }
        return nums;
    }

    private int[] mergeSort1(int[] nums) {
        int length = nums.length;

        // 按照子数组长度进行遍历，子数组长度为1，2，4，8...
        for (int subLength = 1; subLength < length; subLength += subLength) {
            int left = 0;
            int middle = left + subLength - 1;
            int right = middle + subLength;

            while (right < length) {
                merge(nums, left, middle, right);
                left = right + 1;
                middle = left + subLength - 1;
                right = middle + subLength;
            }

            if (left < length && middle < length) {
                merge(nums, left, middle, length - 1);
            }
        }

        return nums;
    }

    private void merge(int[] nums, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int index = 0;

        int[] temp = new int[right - left + 1];

        while (i <= middle && j <= right) {
            if (nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while (i <= middle) {
            temp[index++] = nums[i++];
        }

        while (j <= right) {
            temp[index++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, index);
    }

    private int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = split(nums, left, right);
            quickSort(nums, 0, index - 1);
            quickSort(nums, index + 1, right);
        }
        return nums;
    }

    /**
     * 快速排序双指针分割数组
     *
     * @param nums  目标数组
     * @param left  开始位置
     * @param right 结束位置
     * @return 分割位置
     */
    private int partition(int[] nums, int left, int right) {
        int base = nums[left];

        int i = left + 1;
        int j = right;

        while (true) {
            // 从左往右查找大于基数的值
            while (i <= j && nums[i] <= base) {
                i++;
            }

            // 从右往左查找小于基数的值
            while (i <= j && nums[j] >= base) {
                j--;
            }

            if (i > j) {
                break;
            }

            // 交换两个位置，使得左边的数小于基数，右边的数大于基数
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 把基数和最后的小于基数的值交换，使得基数的位置是正确的有序位置
        nums[left] = nums[j];
        nums[j] = base;
        return j;
    }

    /**
     * 快速排序单指针分割数组
     *
     * @param nums  目标数组
     * @param left  开始位置
     * @param right 结束位置
     * @return 分割位置
     */
    private int split(int[] nums, int left, int right) {
        int i = left;
        int base = nums[i];
        // 遍历数组，查找小于基数的值，移动到左边，大于基数的值移动到右边
        for (int j = left + 1; j <= right; j++) {
            // 如果当前位置的值小于基数，交换之前交大的值和当前值
            if (nums[j] <= base) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // 把基数和最后的小于基数的值交换，使得基数的位置是正确的有序位置
        int temp = nums[left];
        nums[left] = nums[i];
        nums[i] = temp;
        return i;
    }

    private int[] countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        int[] countingArray = new int[max - min + 2];
        Arrays.fill(countingArray, 0);

        for (int i = 0; i < nums.length; i++) {
            countingArray[nums[i]]++;
        }

        int index = 0;
        for (int j = 0; j < countingArray.length; j++) {
            for (int k = 0; k < countingArray[j]; k++) {
                nums[index++] = j;
            }
        }

        return nums;
    }

    private int[] bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        int diff = max - min;
        int bucketCount = diff / 10 + 1;
        List<LinkedList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int num : nums) {
            buckets.get((num - min) / bucketCount).add(num);
        }

        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets.get(i));
        }

        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (Integer v : buckets.get(i)) {
                nums[index++] = v;
            }
        }

        return nums;
    }

    private int[] radioSort(int[] nums) {
        final int bucketCount = 10;
        int bitCount = 0;

        for (int num : nums) {
            bitCount = Math.max(bitCount, String.valueOf(num).length());
        }

        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int i = 0; i < bitCount; i++) {
            for (int num : nums) {
                int radio = (num / (int) Math.pow(10, i)) % 10;
                buckets.get(radio).add(num);
            }

            int index = 0;
            for (int k = 0; k < bucketCount; k++) {
                for (Integer v : buckets.get(k)) {
                    nums[index++] = v;
                }
                buckets.get(k).clear();
            }
        }

        return nums;
    }

    private int[] heapSort(int[] nums) {
        int length = nums.length;

        for (int i = (length - 2) / 2; i >= 0; i--) {
            downAdjust(nums, i, length);
        }

        for (int i = length - 1; i >= 1; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            downAdjust(nums, 0, i);
        }
        return nums;
    }

    private int[] downAdjust(int[] nums, int parent, int length) {
        int parentNode = nums[parent];
        int child = parent * 2 + 1;

        while (child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }

            if (parentNode > nums[child]) {
                break;
            }

            nums[parent] = nums[child];
            parent = child;
            child = parent * 2 + 1;
        }
        nums[parent] = parentNode;
        return nums;
    }
}
