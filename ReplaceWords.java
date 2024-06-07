/*648. Replace Words
Solved
Medium
Topics
Companies
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
 

Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces. */

import java.util.List;
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(trie.findShortestRoot(word));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReplaceWords solution = new ReplaceWords();
        List<String> dictionary1 = List.of("cat", "bat", "rat");
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(dictionary1, sentence1)); // Output: "the cat was rat by the bat"

        List<String> dictionary2 = List.of("a", "b", "c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(solution.replaceWords(dictionary2, sentence2)); // Output: "a a b c"
    }
}
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public String findShortestRoot(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                break;
            }
            node = node.children[index];
            prefix.append(c);
            if (node.isEndOfWord) {
                return prefix.toString();
            }
        }
        return word;
    }
}
