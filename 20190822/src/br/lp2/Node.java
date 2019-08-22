package br.lp2;

import java.util.ArrayList;

public class Node {

    private ArrayList<Node> children;
    private String name;
    private Node parent;

    public Node(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public Node addChild(String s) {
        Node node = new Node(s);
        return addChild(node);
    }

    public Node addChild(Node node) {
        children.add(node);
        node.parent = this;
        return node;
    }

    public String getName() {
        return name;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isSibling(Node other) {
        if(other == null){
            return false;
        }
        return this.parent == other.parent;
    }

    public int NodeGegree() {
        return children.size();
    }

    public int treeGegree() {
        //TODO calcular o grau de todos os nós filhos
        return children.size();
    }
}
