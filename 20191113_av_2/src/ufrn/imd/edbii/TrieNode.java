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
/*                System.out.println("ultima: " + palavra.charAt(posicao));*/
                return;
            }else{
                TrieNode trie = new TrieNode();
                this.children.put((Character) palavra.charAt(posicao), trie);
/*                System.out.println("nao e a ultima: " + palavra.charAt(posicao));*/
                trie.insert(palavra, ++posicao);
            }
        }else{
/*            System.out.println("tem outros: " + palavra.charAt(posicao));*/
            child.insert(palavra, ++posicao);
        }
    }

    private TrieNode getChild(char c) {
        return children.get((Character) c);
    }


}
