/*
---------Question----------

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.

----------End Question----------
*/

class Solution {
public:
    /// Takes an array of numbers as input
    // returns the power set
    // Time Complexity - O(2^N) - uses a branching recursion technique
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        rec(0, nums, vector<int>{}, ans);
        return ans;
    }
    
    // recursive helper function
    void rec(int index, vector<int> &nums, vector<int> curSet, vector<vector<int>> &ans){
        if(index == nums.size()){
            ans.push_back(curSet);
            return;
        }
        rec(index+1, nums,curSet,ans);
        curSet.push_back(nums[index]);
        rec(index+1,nums,curSet, ans);
    }
};
