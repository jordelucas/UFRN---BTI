package br.lp2;

public class Main {
    public static void main(String[] args) {
        Node root = new Node("Raiz");
        Node child = root.addChild("Filho 1");
        root.addChild(new Node("Filho 2"));

        root.addChild(new Node("Neto 2"));
    }
}
