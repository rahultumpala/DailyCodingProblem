/*
----------Question----------

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space.

*/

// can be solved using a heap [or] deque(double ended queue)
// this implementation uses a deque
// Time Complexity  - O(n)
// Space complexity - O(k) without including result array
class Solution {
public:
    vector<int> subArrayMax(vector<int>& nums, int k) {
        vector<int> res;
        deque<int> q;
        int l=0,r=0;
        while(r<nums.size()){
            while( !q.empty()  && nums[q.back()] < nums[r] ){
                q.pop_back();
            }
            if(!q.empty() && q.front()<l ){
                    q.pop_front();
            }
            q.push_back(r);
            
            if( r+1 >= k){
                res.push_back( nums[q.front()] );
                l++;
            }
                
            r++;
        }
        return res;
    }
};
