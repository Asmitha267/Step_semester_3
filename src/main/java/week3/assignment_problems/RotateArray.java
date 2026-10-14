package main.java.week3.assignment_problems;

// File name: RotateArray.java

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {

        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int newIndex = (i + k) % nums.length;

            result[newIndex] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = rotateArray(nums, k);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}

