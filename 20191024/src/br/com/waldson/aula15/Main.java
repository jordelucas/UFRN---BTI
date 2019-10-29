package br.com.waldson.aula15;

public class Main {

    public static void main(String[] args) {
        AvlTree<Pessoa> tree = new AvlTree<>();
        tree.insert(new Pessoa(3));
        tree.insert(new Pessoa(2));
        tree.insert(new Pessoa(1));
        tree.insert(new Pessoa(4));
        tree.insert(new Pessoa(5));
        tree.insert(new Pessoa(6));
        tree.insert(new Pessoa(7));
        if (tree.isBalanced()) {
            System.out.println("Está balanceada");
        }
    }
}
