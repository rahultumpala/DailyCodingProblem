/*

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String... args) {
        System.out.println(findLongestSubstring("abcba", 2)); // bcb
    }

    public static String findLongestSubstring(String str, int k) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        String res = null;

        for (int i = 0, j = 0; j < str.length(); ) {
            if (map.containsKey(str.charAt(j)))
                map.get(str.charAt(j)).add(j++);
            else if (map.size() < k) {
                map.put(str.charAt(j), new HashSet<>());
                map.get(str.charAt(j)).add(j++);
            } else {
                if (res == null || j - i + 1 > res.length())
                    res = str.substring(i, j);

                map.get(str.charAt(i)).remove(i);

                if (map.get(str.charAt(i)).isEmpty())
                    map.remove(str.charAt(i));

                i++;
            }
        }

        return res;
    }

}
