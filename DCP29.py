## QUESTION

# Given an array of characters chars, compress it using the following algorithm:
  
# Begin with an empty string s. For each group of consecutive repeating characters in chars:

# If the group's length is 1, append the character to s.
# Otherwise, append the character followed by the group's length.
# The compressed string s should not be returned separately, but instead, be stored in the input character array chars. 
# Note that group lengths that are 10 or longer will be split into multiple characters in chars.
# After you are done modifying the input array, return the new length of the array.
# You must write an algorithm that uses only constant extra space.
# Ex:
# Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
# Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

class Solution:
    def compress(self, chars: List[str]) -> int:
        if(len(chars) == 0):
            return 0
        curchar = chars[0]
        curlen = 0
        prevMod = 0
        for i in range(len(chars)):
            if chars[i] == curchar:
                curlen+=1
            else:
                nextchar = chars[i]
                chars[prevMod] = curchar
                if curlen == 1:
                    prevMod +=1
                else: 
                    strlen = str(curlen)
                    prevMod += 1
                    for k in range(len(strlen)):
                        chars[prevMod] = strlen[k]
                        prevMod+=1
                curlen = 1
                curchar = nextchar
        if(curlen > 1):
            chars[prevMod] = curchar
            strlen = str(curlen)
            prevMod += 1
            for k in range(len(strlen)):
                chars[prevMod] = strlen[k]
                prevMod+=1
        else:
            chars[prevMod] = curchar
            prevMod+=1
        return prevMod
