package ufrn.imd.bti;

import java.util.Arrays;

public class FilaBanco {

    private Pessoa [] pessoas;
    private int size; //quantos elementos tem
    private int capacity; //wuantos elementos pode ter

    public FilaBanco () {
        this(10);
    }

    public FilaBanco (int capacity) {
        pessoas = new Pessoa[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void addPessoa(String nome, int idade) {
        addPessoa(new Pessoa(nome, idade));
    }

    public void addPessoa(Pessoa pessoa) {
        this.ensureCapacity();
        this.pessoas[getSize()] = pessoa;
        heapfyUp(getSize());
        size++;
    }

    private void heapfyUp (int index) {
        if (!hasParent(index)) {
            return;
        }

        int parentIndex = getParendIndex(index);

        Pessoa node = pessoas[index];
        Pessoa pai = pessoas[parentIndex];

        if (node.getIdade() > pai.getIdade()) {
            pessoas[index] = pai;
            pessoas[parentIndex] = node;
            heapfyUp(parentIndex);
        }
    }

    private boolean hasParent (int index) {
        return getParendIndex(index) >= 0 && getParendIndex(index) < size;
    }

    private int getParendIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (getSize() == capacity) {
            this.pessoas = Arrays.copyOf(this.pessoas, getSize() * 2);
            capacity = getSize() * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public Pessoa peek() {
        if (getSize() == 0) {
            return null;
        }

        return pessoas[0];
    }

    public void remove() {

    }
}
