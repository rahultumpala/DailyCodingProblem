/*
Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana"
*/

class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        int dp[n][n];
        memset(dp,0,sizeof(dp));
        string ans = "";
        for(int i=0;i<n;i++)
            dp[i][i] = 1;
        for(int i = 0;i<n-1;i++)
            if(s[i] == s[i+1]) dp[i][i+1] = 1;
        int len = 2;
        
        // for some iterations
        for(int start=0;start<n;start++){
            // traverse diagonally
            for(int i =0;i<n;i++){
                int j = i+len;
                if(j>=n) continue;
                if(s[i] == s[j] && dp[i+1][j-1] ==1) dp[i][j] = 1;
            }
            len++;
        }
        for(int row= 0 ;row<n;row++){
            int max = 0;
            int start = row-1;
            while(++start < n) if(dp[row][start] ==1 ) max = start;
            if( max - row +1 > ans.length()) ans = s.substr(row,max-row+1);
        }    
        
        return ans;
    }
    
 
};
