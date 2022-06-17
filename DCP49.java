/*
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
*/

public class Solution {

    public static void main(String... args) {
        System.out.println(findMaxSum(34, -50, 42, 14, -5, 86));    // 137
        System.out.println(findMaxSum(-5, -1, -8, -9));    // 0
    }

    public static int findMaxSum(int... arr) {
        int maxSum = 0;

        for (int i = 0, sum = 0; i < arr.length; i++) {
            maxSum = Math.max(maxSum, arr[i]);
            maxSum = Math.max(maxSum, sum = Math.max(sum + arr[i], 0));
        }

        return maxSum;
    }

}
