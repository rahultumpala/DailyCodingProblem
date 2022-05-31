/*
--------- Question ---------

Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.

--------- End Question ----------
*/

#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    // Time complexity - O(N)
    // Space Complexity - O(N) uses a hashmap
    // Constant space compexity solutions involve XORing or BitCounting but are unclear, hence hashmap solution is implemented
    int singleElement(int arr[] ,int N) {
        
        map<int,int> m;
        for(int i =0 ;i<N;i++){
            m[arr[i]]++;
        }
        for( auto item : m ){
            if(item.second == 1) return item.first;
        }
        return 0;
    }
};
