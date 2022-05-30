/*
----------Question---------

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.

-------- End Question---------
*/

class Solution {
public:
  
    // Time Complexity - O(N) (where N = length of string)
    // Space Complexity - O(N) at worst when there are only opening brackets and 0 closing brackets
    bool isValid(string s) {
        stack<char> st;
        for(char c: s){
            if(c == '{' || c == '[' || c == '(') st.push(c);
            else{
                if(st.empty()) return false;
                if(st.top() == '{' && c != '}') return false;
                if(st.top() == '[' && c != ']') return false;
                if(st.top() == '(' && c != ')') return false;
                st.pop();
            }
        }
        return st.empty();
    }
};
