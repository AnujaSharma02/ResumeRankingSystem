public class Trie {
    private class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int i = c - 'a';
                if (current.children[i] == null)
                    current.children[i] = new Node();
                current = current.children[i];
            }
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        Node current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int i = c - 'a';
                if (current.children[i] == null)
                    return false;
                current = current.children[i];
            }
        }
        return current.isWord;
    }
}
