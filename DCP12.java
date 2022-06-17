/*
There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
*/

import java.util.Arrays;

public class Solution {

    public static void main(String... args) {
        System.out.println(countUniqueWays(1, 1, 2)); // 1
        System.out.println(countUniqueWays(2, 1, 2)); // 2
        System.out.println(countUniqueWays(3, 1, 2)); // 3
        System.out.println(countUniqueWays(4, 1, 2)); // 5

        System.out.println(countUniqueWays(4, 1, 3, 5)); // 3
    }

    public static int countUniqueWays(int n, int... steps) {
        Arrays.sort(steps);
        return _countUniqueWays(n, 0, 0, steps);
    }

    private static int _countUniqueWays(int n, int cur, int res, int... steps) {
        if (cur == n)
            res++;

        if (cur < n) {
            for (int i = 0; i < steps.length; i++)
                res = _countUniqueWays(n, cur + steps[i], res, steps);
        }

        return res;
    }

}
