package ufrn.imd.edbii;

import java.util.*;

public class TrieNode {
    private boolean isWord;
    private HashMap<Character, TrieNode> children;
    private String text;

    public TrieNode(String text) {
        this.isWord = true;
        this.text = text;
        this.children = new HashMap<Character, TrieNode>();
    }

    private boolean isWord() {
        return isWord;
    }

    private void setWord() {
        isWord = !isWord();
    }

    private String getText() {
        return text;
    }

    private boolean isEmpty(){
        return this.children.isEmpty();
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
            }else{
                TrieNode trie = new TrieNode();
                this.children.put((Character) palavra.charAt(posicao), trie);
                trie.insert(palavra, ++posicao);
            }
        }else{
            child.insert(palavra, posicao+1);
        }
    }

    public void search(String palavra) {
        TrieNode node = search(palavra, 0);
        if (node != null) {
            if(node.isWord()){
                System.out.println(search(palavra, 0).getText());
            }else{
                System.out.println("palavra nao existe");
            }
        }else{
            System.out.println("palavra nao existe");
        }
    }

    private TrieNode search(String palavra, int position) {
        TrieNode node = children.get(palavra.charAt(position));

        if(node == null) {
            return null;
        }

        if(position == palavra.length()-1){
            return node;
        }

        return node.search(palavra, ++position);
    }

    private TrieNode getChild(char c) {
        return children.get((Character) c);
    }

    public Queue<String> autocomplete(String palavra) {
        TrieNode node = search(palavra, 0);

        Queue<TrieNode> list = new LinkedList<TrieNode>();

        Queue<String> palavras = new LinkedList<String>();

        if(node == null){
            System.out.println("não encontrado");
            return palavras;
        }

        if(node.isWord()){
            palavras.add(node.getText());
        }

        for (Character key : node.children.keySet()) {
            list.add(node.children.get(key));
        }

        autocomplete(list, palavras);

        return palavras;
    }

    public void autocomplete(String palavra, int qtd) {
        TrieNode node = search(palavra, 0);

        if(node == null){
            System.out.println("não encontrado");
            return;
        }

        Queue<TrieNode> list = new LinkedList<TrieNode>();

        Queue<String> palavras = new LinkedList<String>();

        if(node.isWord()){
            palavras.add(node.getText());
        }

        for (Character key : node.children.keySet()) {
            list.add(node.children.get(key));
        }

        autocomplete(list, palavras, qtd);

        for (String current : palavras) {
            System.out.println(current);
        }
    }

    private void autocomplete(Queue<TrieNode> list, Queue<String> palavras) {
        TrieNode node = list.peek();

        if (node == null) {
            return;
        }

        if(node.isWord()){
            palavras.add(node.getText());
        }

        for (Character key : node.children.keySet()) {
            list.add(node.children.get(key));
        }

        list.remove();

        autocomplete(list, palavras);
    }

    private void autocomplete(Queue<TrieNode> list, Queue<String> palavras, int qtd) {
        TrieNode node = list.peek();

        if (node == null) {
            return;
        }

        if(palavras.size() == qtd){
            return;
        }

        if(node.isWord()){
            palavras.add(node.getText());
        }

        for (Character key : node.children.keySet()) {
            list.add(node.children.get(key));
        }

        list.remove();

        autocomplete(list, palavras, qtd);
    }

    public void remove(String palavra) {
        boolean result = remove(palavra, 0);
        if(result){
            System.out.println("Removido");
        }else{
            System.out.println("Palavra nao encontrada");
        }
    }

    private boolean remove(String palavra, int position) {
        TrieNode node = children.get(palavra.charAt(position));

        if(node == null) {
            return false;
        }

        if(position == palavra.length()-1){
            if(node.isWord()){
                node.setWord();
                if(node.isEmpty()){
                    children.remove(palavra.charAt(position));
                }
                return true;
            }
            return false;
        }

        boolean result = node.remove(palavra, position+1);

        if(node.isEmpty() && !node.isWord()){
            children.remove(palavra.charAt(position));
        }

        return result;
    }

    public void printSuggestions(Queue<String> palavras) {
        for (String current : palavras) {
            System.out.println(current);
        }
    }

}
