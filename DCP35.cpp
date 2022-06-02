/*
----------Question----------

Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

---------End Question----------
*/
  
class Solution {
public:
  
    // Time complexity = O(N) linear
    // Space Complexity = O(1) Constant
    // Uses a 2 pointer method to swap Rs and Bs, so automatically Gs come in between
    void sortColors(vector<char>& chars) {
        int left=0, right = chars.size()-1;
        
        if(right+1 == 0 ) return; //edge case when length of array is 0
        
        for(int i =0 ;i< chars.size(); i++){
            
            while(chars[i] == 2 && i<right)
                swap(chars[i], chars[right--]);
            
            while(chars[i] == 0 && i>left) 
                swap(chars[left++],chars[i]);
        
        }
        return;
    }
};
