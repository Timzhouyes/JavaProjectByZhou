import java.util.TreeMap;

public class WordDictionary {
//For question 211 in Leetcode: Based on the Trie I created
    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        public Node(boolean isNode) {
            this.isWord = isNode;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public WordDictionary() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (cur.isWord != true) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean search(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            Character c= word.charAt(i);
            if(c=='.')
                cur=cur.next.;
            if(cur.next.get(c)==null)
                return false;
        }
        return cur.isWord;
    }




}
