package br.com.waldson.aula11;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }

    public Node remove(int key) {

        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                if (this.left.value == key) {
                    //folha
                    if(leaf(this.left)) {
                        this.left = null;
                        return this;
                    }

                    //um filho
                    Node temp = one(this.left);
                    if (temp != null) {
                        this.left = temp;
                        return this;
                    }

                    //dois filhos
                    temp = this.left;
                    if(temp.left.right == null) {
                        temp.left.insert(temp.right);
                        this.left = temp.left;
                        return this;
                    }

                    temp = this.left.left;
                    Node maiorValor = maiorValor(this.left.left);
                    maiorValor.insert(this.left.right);
                    maiorValor.insert(this.left.left);
                    this.left = maiorValor;
                    return this;
                } else {
                    return this.left.remove(key);
                }
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                if (this.right.value == key) {
                    //folha
                    if(leaf(this.right)) {
                        this.right = null;
                        return this;
                    }

                    //um filho
                    Node temp = one(this.right);
                    if (temp != null) {
                        this.right = temp;
                        return this;
                    }

                    //dois filhos
                    temp = this.right;
                    if(temp.left.right == null) {
                        temp.left.insert(temp.right);
                        this.right = temp.left;
                        return this;
                    }

                    temp = this.right.left;
                    Node maiorValor = maiorValor(this.right.left);
                    maiorValor.insert(this.right.right);
                    maiorValor.insert(this.right.left);
                    this.right = maiorValor;
                    return this;
                } else {
                    return this.right.remove(key);
                }
            }
        }

        return null;
    }

    private Node one(Node node) {
        if(node.left != null && node.right == null) {
            return node.left;
        }

        if(node.left == null && node.right != null) {
            return node.right;
        }

        return null;
    }

    public boolean leaf (Node node) {
        return node.left == null && node.right == null;
    }

    public Node maiorValor (Node node) {
        if (node.right.right == null) {
            Node temp = node.right;
            node.right = null;
            return temp;
        }

        return maiorValor(node.right);
    }

}
