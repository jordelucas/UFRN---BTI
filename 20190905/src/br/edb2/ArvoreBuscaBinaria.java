package br.edb2;

public class ArvoreBuscaBinaria {

    private Node root = null;

    public void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        root.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public class Node {
        private Node left = null;
        private Node right = null;
        private int value = 0;

        public Node (int value) {
            this.value = value;
        }

        public void insert(Node node) {
            if (node.value > this.value) {
                if (right == null) {
                    this.right = node;
                }else{
                    right.insert(node);
                }
            }else if(node.value < this.value) {
                if (left == null) {
                    this.left = node;
                }else{
                    left.insert(node);
                }
            }
        }

        public Node search(int i) {
            if(i == this.value){
                return this;
            }

            if(i < this.value) {
                if(left == null) {
                    return null;
                }
                return left.search(i);
            }

            if(i > this.value) {
                if(right == null) {
                    return null;
                }
                return right.search(i);
            }

            return null;
        }
    }

    public Node search (int i) {
        if(root == null) {
            return null;
        }

        return root.search(i);
    }

}