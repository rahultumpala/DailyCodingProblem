package DCP;

/*
        --------- Question: ---------

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

        --------- End Question ---------
*/
public class DCP02 {
    public static int[] solve(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for(int i =1; i< n; i++){
            ans[i] = ans[i-1]*nums[i];
        }
        int rightProduct = 1;
        for(int i=n-1; i>0; i--){
            ans[i] = ans[i-1]*rightProduct;
            rightProduct *= nums[i];
        }
        ans[0] = rightProduct;
        return ans;
    }

    /*
        N - number of items in the array
        Time Complexity - O(N)
        Space Complexity - O(1)
        uses constant space (without taking into account the `ans` array)
     */
    // Driver Code
    public static void main(String[] args) throws Exception{
        int array[] = { 1, 4, 45, 6, 10, 8 };
        final long startTime = System.currentTimeMillis();
        int[] ans = solve(array);
        final long endTime = System.currentTimeMillis();
        for (int i = 0; i < ans.length ; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
