package br.edb2;

public class Node {

    private Node left = null;
    private Node right = null;

    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node setLeft(Node node) {
        this.left = node;
        return node;
    }

    public Node setRight(Node node) {
        this.right = node;
        return node;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void accessPreOrder(NodeVisitor v){
        v.visit(this);

        if (left != null) {
            left.accessPreOrder(v);
        }

        if (right != null) {
            right.accessPreOrder(v);
        }
    }

    public void accessInOrder(NodeVisitor v){
        if (left != null) {
            left.accessInOrder(v);
        }

        v.visit(this);


        if (right != null) {
            right.accessInOrder(v);
        }
    }

    public void accessPosOrder(NodeVisitor v){
        if (left != null) {
            left.accessPosOrder(v);
        }

        if (right != null) {
            right.accessPosOrder(v);
        }

        v.visit(this);

    }
}