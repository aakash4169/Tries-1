//Time Complexity: O(L)
//Space Complexity : O(N*L)


/*

ChatGPT said:
This code implements a Trie (Prefix Tree) data structure, useful for efficient insert, search,
and prefix matching operations on strings. Each node (TrieNode) maintains an array of 26
children (for lowercase English letters) and a boolean to mark the end of a word.
The insert method builds the trie by creating nodes for each character if they don't
already exist. The search method checks whether a complete word exists, while startsWith
verifies if any word in the trie starts with the given prefix.
This structure is highly optimized for problems involving dictionaries and autocomplete features.
* */


class PrefixTree {


    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children=new TrieNode[26];
        }
    }
    public Trie() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray())
        {
            if(curr.children[c - 'a']==null)
            {
                curr.children[c - 'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray())
        {
            if(curr.children[c - 'a']==null)
            {
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray())
        {
            if(curr.children[c - 'a']==null)
            {
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */