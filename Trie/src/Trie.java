import java.util.TreeMap;

public class Trie {

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

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
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

    public boolean contains(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            Character c= word.charAt(i);
            if(cur.next.get(c)==null)
                return false;
            cur=cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix){
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            Character c= prefix.charAt(i);
            if(cur.next.get(c)==null)
                return false;
            cur=cur.next.get(c);
        }
        return true;
    }


}
