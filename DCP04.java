package DCP;

/*
        --------- Question: ---------
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

        --------- End Question ---------
*/
public class DCP04 {
    public static int solve(int[] nums) {
        int n = nums.length;
        for(int i =0 ; i< n; i++){
            while(nums[i] >0 && nums[i] <=n && nums[nums[i]-1] != nums[i])
            {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=0; i< n; i++){
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }

    /*
        N - number of items in the array
        Time Complexity - O(N)
        Space Complexity - O(1)
        uses constant space due to in-place modification
     */
    // Driver Code
    public static void main(String[] args) throws Exception{
        int array[] = {3, 4, -1, 1};
        final long startTime = System.currentTimeMillis();
        int ans = solve(array);
        final long endTime = System.currentTimeMillis();
        System.out.println(ans);
        System.out.println();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
