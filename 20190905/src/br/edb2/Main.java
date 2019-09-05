package br.edb2;


public class Main {
    public static void main(String[] args) {
        ArvoreBuscaBinaria tree = new ArvoreBuscaBinaria();
        tree.insert(10);
        tree.insert(100);
        tree.insert(200);
        tree.insert(200);
        tree.insert(30);
        ArvoreBuscaBinaria.Node value = tree.search(31);

        if(value != null) {
            System.out.println("Encontrou o elemento");
        }else{
            System.out.println("Elemento nao encontrado");
        }
    }
}