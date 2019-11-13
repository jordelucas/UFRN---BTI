package ufrn.imd.edbii;

import java.util.HashMap;

public class TrieNode {
    private boolean isWord;
    private HashMap<Character, TrieNode> children;
    private String text;

    public TrieNode(String text) {
        this.isWord = true;
        this.text = text;
        this.children = new HashMap<Character, TrieNode>();
    }

    public boolean isWord() {
        return isWord;
    }

    public String getText() {
        return text;
    }

    public TrieNode() {
        this.isWord = false;
        this.text = "";
        this.children = new HashMap<Character, TrieNode>();
    }

    public void insert(String palavra) {
        insert(palavra, 0);
    }

    private void insert(String palavra, int posicao) {
        TrieNode child = getChild(palavra.charAt(posicao));
        if (this.children.isEmpty() || child == null){
            if(posicao == palavra.length()-1){
                TrieNode trie = new TrieNode(palavra);
                this.children.put((Character) palavra.charAt(posicao), trie);
                return;
            }else{
                TrieNode trie = new TrieNode();
                this.children.put((Character) palavra.charAt(posicao), trie);
                trie.insert(palavra, ++posicao);
            }
        }else{
            child.insert(palavra, ++posicao);
        }
    }

    private TrieNode getChild(char c) {
        return children.get((Character) c);
    }


    public void readTrie() {
/*        for (Character key : children.keySet()) {
            System.out.println(key);
        }*/

        for (Character key : children.keySet()) {
            System.out.println("**" + key + "**");
            if(children.get(key).isWord()){
                System.out.println(children.get(key).getText());
            }
            this.children.get(key).readTrie();
        }
    }
}
