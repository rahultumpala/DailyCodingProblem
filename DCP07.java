/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed
*/

public class Solution {

    public static void main(String... args) {
        System.out.println(count("1"));     // 1
        System.out.println(count("11"));    // 2
        System.out.println(count("111"));   // 3
        System.out.println(count("1111"));  // 5
    }

    public static int count(String msg) {
        if (msg == null || msg.isEmpty())
            return 0;
        if (msg.length() == 1)
            return 1;
        if (msg.length() == 2)
            return 2;
        return count(msg.substring(1)) + count(msg.substring(2));
    }

}
