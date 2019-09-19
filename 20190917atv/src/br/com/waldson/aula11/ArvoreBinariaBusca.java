package br.com.waldson.aula11;

public class ArvoreBinariaBusca {
    private Node raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public Node getRoot() {
        return raiz;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

    public Node remove(int value) {
        if (isEmpty()) {
            return null;
        }

        if (raiz.getValue() == value) {
            if (leaf()) {
                raiz = null;
                return null;
            }

            Node temp = one();
            if (temp != null) {
                raiz = temp;
                return raiz;
            }

            temp = raiz.getLeft();
            if(temp.getRight() == null) {
                temp.insert(raiz.getRight());
                raiz = temp;
                return raiz;
            }

            Node maiorValor = maiorValor(temp);
            maiorValor.insert(raiz.getRight());
            maiorValor.insert(raiz.getLeft());
            raiz = maiorValor;
            return null;
        }

        return raiz.remove(value);
    }

    public boolean leaf () {
        return raiz.getLeft() == null && raiz.getRight() == null;
    }

    private Node one() {
        if(raiz.getLeft() != null && raiz.getRight() == null) {
            return raiz.getLeft();
        }

        if(raiz.getLeft() == null && raiz.getRight() != null) {
            return raiz.getRight();
        }

        return null;
    }

    private Node maiorValor (Node node) {
        if (node.getRight().getRight() == null) {
            Node temp = node.getRight();
            node.setRight(null);
            return temp;
        }

        return maiorValor(node.getRight());
    }

}
