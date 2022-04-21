package DCP;

/*
        --------- Question: ---------
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?

        --------- End Question ---------
*/
public class DCP09 {

    /*
    [taken] and [notTaken] signify whether the previous value was considered while adding or not respectively
    This code works under the assumption that only positive values are used in the array
     */
    public static int solve(int[] nums) {
        int n = nums.length;
        int taken = nums[0];
        int notTaken = 0;
        for(int i =1 ; i< n;i++){
            if(taken > notTaken){
                notTaken = Math.max(notTaken + nums[i],taken);
            }else{
                taken = Math.max(taken + nums[i],notTaken);
            }
        }
        return Math.max(taken, notTaken);
    }

    /*
        N - number of items in the array
        Time Complexity - O(N)
        Space Complexity - O(1)
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
