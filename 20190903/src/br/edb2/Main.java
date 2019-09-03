package br.edb2;


public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(5));
        root.setRight(new Node(30));
        root.setValue(20);

        PrintVisitor p = new PrintVisitor();

        root.accessPreOrder(p);
    }
}