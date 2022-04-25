package DCP;

import java.util.ArrayList;
import java.util.List;

class TrieNode{
    boolean ends = false;
    TrieNode[] arr = new TrieNode[26];
    TrieNode(){}
}

class Trie {
    static TrieNode head;
    public Trie() {
        head =  new TrieNode();
    }

    public static void insert(String word) {
        char c = word.charAt(0);
        if(head.arr[c-'a'] == null)
            head.arr[word.charAt(0)-'a'] = new TrieNode();
        TrieNode start = head.arr[c-'a'];
        for(int i =1 ; i< word.length(); i++){
            c = word.charAt(i);
            if(start.arr[c-'a'] == null)
                start.arr[c-'a'] = new TrieNode();
            start = start.arr[c-'a'];
        }
        start.ends = true;
    }

    public static List<String> getSuggestions(String word) {
        TrieNode start = head.arr[word.charAt(0)-'a'];
        List<String> ans = new ArrayList<String>();
        if(start == null )return ans;
        String cur = word;
        for(int i=1; i< word.length(); i++){
            start = start.arr[word.charAt(i)-'a'];
            if(start == null) return ans;
        }
        if(start.ends) ans.add(cur);
        rec(start, cur, ans);
        return ans;
    }

    // recursively calls itself and crawls the trie to look for words
    // adds them to the `list` reference passed as parameter
    private static void rec(TrieNode node, String cur, List<String> list){
        if(node == null) return;
        if(node.ends) list.add(cur);
        for(int i =0 ;i < 26;i++){
            if(node.arr[i] != null){
                rec(node.arr[i],cur + Character.toString( (char) (i+'a') ), list);
            }
        }
    }
}

/*
        --------- Question: ---------
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

        --------- End Question ---------
*/
public class DCP11 {

    /*
        Uses the same space as number of items in the initial set of strings
        Uses a Trie Data Structure for efficient searching of words to the given prefix string
     */
    // Driver Code
    public static void main(String[] args) throws Exception{
        Trie head = new Trie();
        Trie.insert("dog");
        Trie.insert("deal");
        Trie.insert("deer");
        final long startTime = System.currentTimeMillis();
        List<String> ans = Trie.getSuggestions("de");
        final long endTime = System.currentTimeMillis();
        System.out.println(ans);
        System.out.println();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
