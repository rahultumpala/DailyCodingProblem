package DCP;

import java.util.*;

/*
--------- Question: ---------

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

--------- End Question ---------
 */
public class DCP01 {

    // Solve Function
    public static boolean solve(int[] arr, int sum ){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean found = false;
        for(int i =0 ; i< arr.length; i++){
            if( map.containsKey(sum - arr[i]) ){
                found = true;
                break;
            }
            else {
                map.put(arr[i], 0);
            }
        }
        return found;
    }

    /*
        Time Complexity - O(N) assuming no collisions and decent hash function
        Space Complexity - O(N) because of HashMap
     */
    // Driver Code
    public static void main(String[] args) throws Exception{
        int array[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 16;
        final long startTime = System.currentTimeMillis();
        boolean ans = solve(array,sum);
        final long endTime = System.currentTimeMillis();
        System.out.println(ans);
        System.out.println("Total execution time: " + (endTime - startTime));
    }


}


