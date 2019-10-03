package br.com.waldson.aula11;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arvore.insert(
                new Node(random.nextInt() % 10)
            );
        }

        int result = arvore.height();

        switch (result) {
            case 0:
                System.out.println("A arvore nao esta balanceada");
                break;
            case 1:
                System.out.println("A arvore esta balanceada");
                break;
            case -1:
                System.out.println("Arvore esta vazia");
                break;
            default:
                System.out.println("Ocorreu um erro");
                break;
        }

        JFrame frame = new JFrame("Visualizador de ABB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        ArvoreBinariaBuscaView view = new ArvoreBinariaBuscaView(arvore);
        frame.add(view);

        frame.setVisible(true);
    }
}
