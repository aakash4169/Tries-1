import java.util.HashSet;
import java.util.List;

//Time Complexity: O(nl)
//Space Complexity: O(nl)
/**
 This solution builds a Trie from all the root words provided in the dictionary.
 For each word in the sentence, it tries to find the shortest prefix from the Trie
 that matches a root word. If a matching root word is found, the word is replaced by
 that root; otherwise, the original word is kept. The Trie helps quickly find prefixes in
 O(L) time per word, where L is the word length.
 Finally, all the processed words are combined to reconstruct the modified sentence.
 */

class ReplaceWords {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children=new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word)
    {
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
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root=new TrieNode();
        for(String word:dictionary)
        {
            insert(word);
        }

        StringBuilder result=new StringBuilder();
        String[] splitString=sentence.split(" ");
        for(int i=0;i<splitString.length;i++)
        {
            String split=splitString[i];
            if(i>0)
                result.append(" ");
            result.append(getShortestVersion(split));
        }

        return result.toString();
    }

    private String getShortestVersion(String word)
    {
        TrieNode curr=root;
        StringBuilder temp=new StringBuilder();
        for(char c :word.toCharArray())
        {
            if(curr.children[c-'a']==null || curr.isEnd)
            {
                break;
            }
            curr=curr.children[c-'a'];
            temp.append(c);

        }

        if(curr.isEnd)
            return temp.toString();
        return word;
    }

}