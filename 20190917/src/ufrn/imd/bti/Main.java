package ufrn.imd.bti;

public class Main {

    public static void main(String[] args) {
        //Heap / Priority Queue
        FilaBanco fila = new FilaBanco();
        fila.addPessoa("Andre", 20);
        fila.addPessoa("Marcos", 10);
        fila.addPessoa("Moreira", 64);
        fila.addPessoa("Filipe", 50);
        fila.addPessoa(new Pessoa("Marta", 5));

        while (fila.getSize() > 0) {
            Pessoa p = fila.peek();
            System.out.println(p.getNome() + " está sendo atendido.");
            fila.remove();
        }
    }
}
